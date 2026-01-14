package com.cybersyn.backend.demo.models.dtos;

public class VentaDTO {
   private Long idProducto;
    private Integer cantidad;


    


    public VentaDTO() {
    }


    public VentaDTO(Long idProducto, Integer cantidad) {
      this.idProducto = idProducto;
      this.cantidad = cantidad;
    }
    public Long getIdProducto() {
      return idProducto;
    }
    public void setIdProducto(Long idProducto) {
      this.idProducto = idProducto;
    }
    public Integer getCantidad() {
      return cantidad;
    }
    public void setCantidad(Integer cantidad) {
      this.cantidad = cantidad;
    } 

    

}
