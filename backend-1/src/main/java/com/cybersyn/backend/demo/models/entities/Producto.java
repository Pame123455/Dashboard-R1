package com.cybersyn.backend.demo.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nombre;
private String descripcion;
private String marca;
private String sabor;
private String contenido;
private String unidad_marca;

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
public String getDescripcion() {
  return descripcion;
}
public void setDescripcion(String descripcion) {
  this.descripcion = descripcion;
}
public String getMarca() {
  return marca;
}
public void setMarca(String marca) {
  this.marca = marca;
}
public String getSabor() {
  return sabor;
}
public void setSabor(String sabor) {
  this.sabor = sabor;
}
public String getContenido() {
  return contenido;
}
public void setContenido(String contenido) {
  this.contenido = contenido;
}
public String getUnidad_marca() {
  return unidad_marca;
}
public void setUnidad_marca(String unidad_marca) {
  this.unidad_marca = unidad_marca;
}


}
