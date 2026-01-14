package com.cybersyn.backend.demo.models.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "gasto")
public class Gasto {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING) 
    private TipoGasto tipo;

    @ManyToOne
    private Comprobante comprobante;

    private String tipoPago; // Transferencia, efectivo, etc.
    private BigDecimal monto;
    private LocalDate fecha;
    private String descripcion;
    public Long getId() {
      return id;
    }
    public void setId(Long id) {
      this.id = id;
    }
    public TipoGasto getTipo() {
      return tipo;
    }
    public void setTipo(TipoGasto tipo) {
      this.tipo = tipo;
    }
    public Comprobante getComprobante() {
      return comprobante;
    }
    public void setComprobante(Comprobante comprobante) {
      this.comprobante = comprobante;
    }
    public String getTipoPago() {
      return tipoPago;
    }
    public void setTipoPago(String tipoPago) {
      this.tipoPago = tipoPago;
    }
    public BigDecimal getMonto() {
      return monto;
    }
    public void setMonto(BigDecimal monto) {
      this.monto = monto;
    }
    public LocalDate getFecha() {
      return fecha;
    }
    public void setFecha(LocalDate fecha) {
      this.fecha = fecha;
    }
    public String getDescripcion() {
      return descripcion;
    }
    public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
    }

    
}
