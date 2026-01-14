package com.cybersyn.backend.demo.models.dtos;

public class ProductoConStockDTO {

private Long id;
    private String nombre;
    private String marca;
    private String sabor;
    private String contenido;
    private String unidadMarca;
    private Integer stockActual;

    
    
    public ProductoConStockDTO(Long id, String nombre, String marca, String sabor, String contenido, String unidadMarca,
        Integer stockActual) {
      this.id = id;
      this.nombre = nombre;
      this.marca = marca;
      this.sabor = sabor;
      this.contenido = contenido;
      this.unidadMarca = unidadMarca;
      this.stockActual = stockActual;
    }
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
    public String getUnidadMarca() {
      return unidadMarca;
    }
    public void setUnidadMarca(String unidadMarca) {
      this.unidadMarca = unidadMarca;
    }
    public Integer getStockActual() {
      return stockActual;
    }
    public void setStockActual(Integer stockActual) {
      this.stockActual = stockActual;
    }

    
}
