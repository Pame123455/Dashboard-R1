package com.cybersyn.backend.demo.models.entities;

import java.time.LocalDateTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;



@Entity
@Table(name = "venta")
public class Venta {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fecha;

    
    public LocalDateTime getFecha() {
      return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
      this.fecha = fecha;
    }

    private int cantidad; 

   @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    public Producto getProducto() {
    return producto;
  }

   public void setProducto(Producto producto) {
     this.producto = producto;
   }

    private LocalDateTime fechaHoraRegistroVenta = LocalDateTime.now();

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

      public int getCantidad() {  // 👈 aquí el getter
        return cantidad;
    }

    public void setCantidad(int cantidad) { // 👈 aquí el setter
        this.cantidad = cantidad;
    }


    public LocalDateTime getFechaHoraRegistroVenta() {
      return fechaHoraRegistroVenta;
    }

    public void setFechaHoraRegistroVenta(LocalDateTime fechaHoraRegistroVenta) {
      this.fechaHoraRegistroVenta = fechaHoraRegistroVenta;
    }


  

    // @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    // private List<VentaProducto> productos;

    // @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    // private List<VentaPack> packs;

    



}