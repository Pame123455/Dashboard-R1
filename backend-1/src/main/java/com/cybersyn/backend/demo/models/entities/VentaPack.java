package com.cybersyn.backend.demo.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "venta_pack")
public class VentaPack {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "id_pack")
    private Pack pack;

    private Integer cantidad;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public Venta getVenta() {
      return venta;
    }

    public void setVenta(Venta venta) {
      this.venta = venta;
    }

    public Pack getPack() {
      return pack;
    }

    public void setPack(Pack pack) {
      this.pack = pack;
    }

    public Integer getCantidad() {
      return cantidad;
    }

    public void setCantidad(Integer cantidad) {
      this.cantidad = cantidad;
    }

    

}
