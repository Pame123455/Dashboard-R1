package com.cybersyn.backend.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cybersyn.backend.demo.models.dtos.VentaDTO;

import com.cybersyn.backend.demo.models.entities.Producto;
import com.cybersyn.backend.demo.models.entities.Stock;
import com.cybersyn.backend.demo.models.entities.Venta;
import com.cybersyn.backend.demo.repository.IProductoRepository;
import com.cybersyn.backend.demo.repository.IStockRepository;
import com.cybersyn.backend.demo.repository.IVentaRepository;

@Service
public class VentaService {

    @Autowired
    private IVentaRepository ventaRepo;

    @Autowired
    private IStockRepository stockRepo;

    @Autowired
    private IProductoRepository productoRepo;

    public Venta registrarVenta(VentaDTO ventaDTO) {
        if (ventaDTO.getIdProducto() == null || ventaDTO.getCantidad() == null || ventaDTO.getCantidad() <= 0) {
            throw new RuntimeException("Debe indicar idProducto y cantidad válidos");
        }

        Long idProducto = ventaDTO.getIdProducto();
        Producto producto = productoRepo.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Stock stock = stockRepo.findByProductoId(idProducto)
                .orElseThrow(() -> new RuntimeException("No hay stock registrado"));

        if (stock.getStockActual() < ventaDTO.getCantidad()) {
            throw new RuntimeException("Stock insuficiente");
        }

        // Descontar stock
        stock.setStockActual(stock.getStockActual() - ventaDTO.getCantidad());
        stockRepo.save(stock);

        // Registrar venta
        Venta venta = new Venta();
        venta.setProducto(producto);
        venta.setCantidad(ventaDTO.getCantidad());
        venta.setFechaHoraRegistroVenta(LocalDateTime.now());

        return ventaRepo.save(venta);
    }

     /* // ✅ Nuevo método para listar todas las ventas
    public List<VentaResponseDTO> listarAllVentas() {
        return ventaRepo.findAll().stream()
            .map(v -> new VentaResponseDTO(
                v.getId(),
                v.getProducto() != null ? v.getProducto().getNombre() : "Producto eliminado",
                v.getCantidad(),
                v.getFechaHoraRegistroVenta()
            ))
            .collect(Collectors.toList());
    }*/


    
     public List<Venta> listarAllVentas() {
         return ventaRepo.findAll();
    }

}
