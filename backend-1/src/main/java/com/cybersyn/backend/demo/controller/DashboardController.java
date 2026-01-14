package com.cybersyn.backend.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybersyn.backend.demo.models.dtos.DashboardDTO;
import com.cybersyn.backend.demo.service.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:5173")
public class DashboardController {

  @Autowired
  private DashboardService dashboardService;

  @GetMapping
  public DashboardDTO obtenerDatosDashboardDTO(){
    return dashboardService.obtenerDatos();
  }
  

}
