package com.cybersyn.backend.demo.models.dtos;

import java.time.LocalDateTime;

public class VentaResponseDTO {

   private Long id;
    private String nombreProducto;
    private Integer cantidad;
    private LocalDateTime fechaHoraRegistroVenta;

    public VentaResponseDTO(Long id, String nombreProducto, Integer cantidad, LocalDateTime fechaHoraRegistroVenta) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.fechaHoraRegistroVenta = fechaHoraRegistroVenta;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public LocalDateTime getFechaHoraRegistroVenta() { return fechaHoraRegistroVenta; }
    public void setFechaHoraRegistroVenta(LocalDateTime fechaHoraRegistroVenta) { this.fechaHoraRegistroVenta = fechaHoraRegistroVenta; }
}
