package com.cybersyn.backend.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybersyn.backend.demo.models.entities.CanalDistribucion;

@Repository
public interface ICanalDistribucionRepository extends JpaRepository<CanalDistribucion, Long> {

}
