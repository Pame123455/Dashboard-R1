package com.cybersyn.backend.demo.models.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "canal_distribucion")
public class CanalDistribucion {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nombre;
private BigDecimal comisionCanal;
private BigDecimal comisionDespacho;

public Long getId() {
  return id;
}
public void setId(Long id) {
  this.id = id;
}
public String getNombre() {
  return nombre;
}
public void setNombre(String nombre) {
  this.nombre = nombre;
}
public BigDecimal getComisionCanal() {
  return comisionCanal;
}
public void setComisionCanal(BigDecimal comisionCanal) {
  this.comisionCanal = comisionCanal;
}
public BigDecimal getComisionDespacho() {
  return comisionDespacho;
}
public void setComisionDespacho(BigDecimal comisionDespacho) {
  this.comisionDespacho = comisionDespacho;
}


}
