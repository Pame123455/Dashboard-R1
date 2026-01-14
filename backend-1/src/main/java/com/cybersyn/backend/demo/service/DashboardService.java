package com.cybersyn.backend.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybersyn.backend.demo.models.dtos.DashboardDTO;
import com.cybersyn.backend.demo.repository.ICanalDistribucionRepository;
import com.cybersyn.backend.demo.repository.IPackProductoRepository;
import com.cybersyn.backend.demo.repository.IProductoRepository;
import com.cybersyn.backend.demo.repository.IStockRepository;
import com.cybersyn.backend.demo.repository.IVentaPackRepository;
import com.cybersyn.backend.demo.repository.IVentaRepository;

@Service
public class DashboardService {

     @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private IVentaRepository ventaRepository;

    @Autowired
    private IVentaPackRepository ventaPackRepository; // Nuevo repositorio para ventas de packs

    @Autowired
    private IPackProductoRepository packProductoRepository;

    @Autowired
    private ICanalDistribucionRepository canalDistribucionRepository;

    @Autowired
    private IStockRepository stockRepository;

    public DashboardDTO obtenerDatos() {
        long totalProductos = productoRepository.count();

        // Ventas separadas
        long totalVentasProductos = ventaRepository.count(); 
        long totalVentasPacks = ventaPackRepository.count(); // nuevo conteo correcto

        // Total general de ventas
        long totalVentas = totalVentasProductos + totalVentasPacks;

        // Otros conteos
        long totalPacks = packProductoRepository.count();
        long totalCanales = canalDistribucionRepository.count();
        long totalStock = stockRepository.count();

        // Retornar DTO con todo separado
        return new DashboardDTO(
            totalProductos,
            totalVentas,
            totalVentasProductos,
            totalVentasPacks,
            totalPacks,
            totalCanales,
            totalStock
        );
    }

}
