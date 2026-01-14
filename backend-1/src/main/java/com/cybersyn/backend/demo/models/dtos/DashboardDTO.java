package com.cybersyn.backend.demo.models.dtos;

public class DashboardDTO {
  private long totalProductos;
    private long totalVentas;
    private long totalVentasProductos;
    private long totalVentasPacks;

    
    private long totalPacks;
    private long totalCanales;
    private long totalStock;

    

    public DashboardDTO() {
    }

    public DashboardDTO(long totalProductos, long totalVentas, long totalVentasProductos,
                        long totalVentasPacks, long totalPacks, long totalCanales, long totalStock) {
        this.totalProductos = totalProductos;
        this.totalVentas = totalVentas;
        this.totalVentasProductos = totalVentasProductos;
        this.totalVentasPacks = totalVentasPacks;
        this.totalPacks = totalPacks;
        this.totalCanales = totalCanales;
        this.totalStock = totalStock;
    }

    public long getTotalProductos() {
      return totalProductos;
    }

    public void setTotalProductos(long totalProductos) {
      this.totalProductos = totalProductos;
    }

    public long getTotalVentas() {
      return totalVentas;
    }

    public void setTotalVentas(long totalVentas) {
      this.totalVentas = totalVentas;
    }

    public long getTotalVentasProductos() {
      return totalVentasProductos;
    }

    public void setTotalVentasProductos(long totalVentasProductos) {
      this.totalVentasProductos = totalVentasProductos;
    }

    public long getTotalVentasPacks() {
      return totalVentasPacks;
    }

    public void setTotalVentasPacks(long totalVentasPacks) {
      this.totalVentasPacks = totalVentasPacks;
    }

    public long getTotalPacks() {
      return totalPacks;
    }

    public void setTotalPacks(long totalPacks) {
      this.totalPacks = totalPacks;
    }

    public long getTotalCanales() {
      return totalCanales;
    }

    public void setTotalCanales(long totalCanales) {
      this.totalCanales = totalCanales;
    }

    public long getTotalStock() {
      return totalStock;
    }

    public void setTotalStock(long totalStock) {
      this.totalStock = totalStock;
    }

    
  

}
