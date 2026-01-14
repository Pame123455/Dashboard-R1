package com.cybersyn.backend.demo.models.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "precio_mercado")
public class PrecioMercado {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Proveedor proveedor;

    private BigDecimal precioCostoProveedor;
    private BigDecimal precioVentaSugerido;
    private BigDecimal precioVentaMercado;
    private BigDecimal precioVentaMarca;

    private LocalDate fechaVigencia;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public Producto getProducto() {
      return producto;
    }

    public void setProducto(Producto producto) {
      this.producto = producto;
    }

    public Proveedor getProveedor() {
      return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
      this.proveedor = proveedor;
    }

    public BigDecimal getPrecioCostoProveedor() {
      return precioCostoProveedor;
    }

    public void setPrecioCostoProveedor(BigDecimal precioCostoProveedor) {
      this.precioCostoProveedor = precioCostoProveedor;
    }

    public BigDecimal getPrecioVentaSugerido() {
      return precioVentaSugerido;
    }

    public void setPrecioVentaSugerido(BigDecimal precioVentaSugerido) {
      this.precioVentaSugerido = precioVentaSugerido;
    }

    public BigDecimal getPrecioVentaMercado() {
      return precioVentaMercado;
    }

    public void setPrecioVentaMercado(BigDecimal precioVentaMercado) {
      this.precioVentaMercado = precioVentaMercado;
    }

    public BigDecimal getPrecioVentaMarca() {
      return precioVentaMarca;
    }

    public void setPrecioVentaMarca(BigDecimal precioVentaMarca) {
      this.precioVentaMarca = precioVentaMarca;
    }

    public LocalDate getFechaVigencia() {
      return fechaVigencia;
    }

    public void setFechaVigencia(LocalDate fechaVigencia) {
      this.fechaVigencia = fechaVigencia;
    }
    
}
