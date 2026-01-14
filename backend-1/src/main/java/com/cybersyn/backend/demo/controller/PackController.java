package com.cybersyn.backend.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybersyn.backend.demo.models.entities.Pack;
import com.cybersyn.backend.demo.repository.IPackRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/packs")
public class PackController {

  @Autowired
  private IPackRepository repository;

  @GetMapping
  public List<Pack> getAll(@RequestParam String param) {
      return repository.findAll();
  }

  @PostMapping
  public Pack save(@RequestBody Pack pack) {
      return repository.save(pack);
  }
  


  


}
