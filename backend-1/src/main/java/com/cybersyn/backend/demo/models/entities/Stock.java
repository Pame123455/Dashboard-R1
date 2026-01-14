package com.cybersyn.backend.demo.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int stockActual;
    private LocalDate fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_canal_distribucion")
    private CanalDistribucion canal;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public int getStockActual() {
      return stockActual;
    }

    public void setStockActual(int stockActual) {
      this.stockActual = stockActual;
    }

    public LocalDate getFechaRegistro() {
      return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
      this.fechaRegistro = fechaRegistro;
    }

    public Producto getProducto() {
      return producto;
    }

    public void setProducto(Producto producto) {
      this.producto = producto;
    }

    public CanalDistribucion getCanal() {
      return canal;
    }

    public void setCanal(CanalDistribucion canal) {
      this.canal = canal;
    }

    
}
