package com.cybersyn.backend.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybersyn.backend.demo.models.entities.VentaPack;

@Repository
public interface IVentaPackRepository extends JpaRepository<VentaPack, Long> {

}
