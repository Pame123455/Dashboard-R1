package com.cybersyn.backend.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybersyn.backend.demo.models.dtos.VentaDTO;
import com.cybersyn.backend.demo.models.dtos.VentaResponseDTO;
import com.cybersyn.backend.demo.models.entities.Producto;
import com.cybersyn.backend.demo.models.entities.Venta;
import com.cybersyn.backend.demo.repository.IProductoRepository;
import com.cybersyn.backend.demo.repository.IVentaRepository;
import com.cybersyn.backend.demo.service.VentaService;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

     @Autowired
    private VentaService ventaService;

     @Autowired
    private IProductoRepository productoRepo;

    @Autowired
    private IVentaRepository ventaRepo;

    /*
    @PostMapping
    public ResponseEntity<?> vender(@RequestBody VentaDTO ventaDTO) {
        try {
            Venta venta = ventaService.registrarVenta(ventaDTO);
            return ResponseEntity.ok(venta);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    } */

   // ✅ Listar todas las ventas (para tabla) sin tirar 500 si producto eliminado
    @GetMapping("/all")
    public List<VentaResponseDTO> listarAllVentas() {
        return ventaRepo.findAll().stream()
                .map(v -> new VentaResponseDTO(
                        v.getId(),
                        Optional.ofNullable(v.getProducto())
                                .map(Producto::getNombre)
                                .orElse("Producto eliminado"),
                        v.getCantidad(),
                        v.getFechaHoraRegistroVenta()
                ))
                .collect(Collectors.toList());
    }
   

 @GetMapping
public List<VentaResponseDTO> listarVentas() {
    return ventaRepo.findAll().stream()
        .map(v -> new VentaResponseDTO(
            v.getId(),
            v.getProducto() != null ? v.getProducto().getNombre() : "Producto eliminado",
            v.getCantidad(),
            v.getFechaHoraRegistroVenta()
        ))
        .collect(Collectors.toList());
}
// ✅ Registrar nueva venta
    @PostMapping
    public ResponseEntity<?> vender(@RequestBody VentaDTO ventaDTO) {
        try {
            Venta venta = ventaService.registrarVenta(ventaDTO);
            return ResponseEntity.ok(venta);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ✅ Eliminar venta
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarVenta(@PathVariable Long id) {
        try {
            ventaRepo.deleteById(id);
            return ResponseEntity.ok("Venta eliminada");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar venta: " + e.getMessage());
        }
    }

    // ✅ Actualizar venta
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarVenta(@PathVariable Long id, @RequestBody VentaDTO dto) {
        try {
            Venta venta = ventaRepo.findById(id)
                    .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

            // Actualizar producto si existe
            Producto producto = productoRepo.findById(dto.getIdProducto())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            venta.setProducto(producto);
            venta.setCantidad(dto.getCantidad());

            ventaRepo.save(venta);
            return ResponseEntity.ok(venta);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar venta: " + e.getMessage());
        }
    }
}
