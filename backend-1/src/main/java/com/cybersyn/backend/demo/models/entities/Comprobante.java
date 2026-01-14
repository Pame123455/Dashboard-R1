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
@Table(name = "comprobante")
public class Comprobante {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING) // ✅ Aquí usamos el enum
    private TipoComprobante tipo;

    @ManyToOne
    private Proveedor proveedor;

    private String descripcion;

    private LocalDate fechaTransferencia;
    private LocalDate fechaRegistro;
    private LocalDate fechaRecepcion;

    private BigDecimal monto;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public TipoComprobante getTipo() {
      return tipo;
    }

    public void setTipo(TipoComprobante tipo) {
      this.tipo = tipo;
    }

    public Proveedor getProveedor() {
      return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
      this.proveedor = proveedor;
    }

    public String getDescripcion() {
      return descripcion;
    }

    public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
    }

    public LocalDate getFechaTransferencia() {
      return fechaTransferencia;
    }

    public void setFechaTransferencia(LocalDate fechaTransferencia) {
      this.fechaTransferencia = fechaTransferencia;
    }

    public LocalDate getFechaRegistro() {
      return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
      this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaRecepcion() {
      return fechaRecepcion;
    }

    public void setFechaRecepcion(LocalDate fechaRecepcion) {
      this.fechaRecepcion = fechaRecepcion;
    }

    public BigDecimal getMonto() {
      return monto;
    }

    public void setMonto(BigDecimal monto) {
      this.monto = monto;
    }

    

}
