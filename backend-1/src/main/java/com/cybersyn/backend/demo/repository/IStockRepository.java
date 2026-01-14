package com.cybersyn.backend.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybersyn.backend.demo.models.entities.Stock;


@Repository
public interface IStockRepository extends JpaRepository<Stock, Long>{

  Optional<Stock> findByProductoId(Long idProducto);
}
