package com.cybersyn.backend.demo.controller;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybersyn.backend.demo.models.dtos.ProductoConStockDTO;
import com.cybersyn.backend.demo.models.dtos.ProductoDTO;
import com.cybersyn.backend.demo.models.entities.Producto;
import com.cybersyn.backend.demo.models.entities.Stock;

import com.cybersyn.backend.demo.repository.IStockRepository;
import com.cybersyn.backend.demo.service.ProductoService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/productos")
public class ProductoController {


    @Autowired
private IStockRepository stockRepo;

 @Autowired
    private ProductoService productoService;

    
 
    
    @GetMapping
    public List<ProductoDTO> listar() {
        List<Producto> productos = productoService.listar();
        return productos.stream()
                .map(p -> new ProductoDTO(
                        p.getId(),
                        p.getNombre(),
                        p.getDescripcion(),
                        p.getMarca(),
                        p.getSabor(),
                        p.getContenido(),
                        p.getUnidad_marca()
                ))
                .toList();
    }

    @PostMapping
    public ProductoDTO guardar(@RequestBody ProductoDTO productoDTO) {
        Producto p = new Producto();
        p.setNombre(productoDTO.getNombre());
        p.setDescripcion(productoDTO.getDescripcion());
        p.setMarca(productoDTO.getMarca());
        p.setSabor(productoDTO.getSabor());
        p.setContenido(productoDTO.getContenido());
        p.setUnidad_marca(productoDTO.getUnidad_marca());

        Producto guardado = productoService.guardar(p);

        return new ProductoDTO(
                guardado.getId(),
                guardado.getNombre(),
                guardado.getDescripcion(),
                guardado.getMarca(),
                guardado.getSabor(),
                guardado.getContenido(),
                guardado.getUnidad_marca()
        );
    }

    @GetMapping("/con-stock")
    public List<ProductoConStockDTO> listarConStock() {
        List<Producto> productos = productoService.listar();
        List<Stock> stocks = stockRepo.findAll();
        Map<Long, Stock> stockMap = stocks.stream()
                .collect(Collectors.toMap(s -> s.getProducto().getId(), s -> s));

        return productos.stream()
                .map(p -> new ProductoConStockDTO(
                        p.getId(),
                        p.getNombre(),
                        p.getMarca(),
                        p.getSabor(),
                        p.getContenido(),
                        p.getUnidad_marca(),
                        stockMap.getOrDefault(p.getId(), new Stock()).getStockActual()
                ))
                .toList();
    }


    @DeleteMapping("/{id}")
public void eliminar(@PathVariable Long id) {
    productoService.eliminar(id);
}


}
