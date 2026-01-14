package com.cybersyn.backend.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybersyn.backend.demo.models.entities.Stock;
import com.cybersyn.backend.demo.repository.IStockRepository;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
 @Autowired
    private IStockRepository repository;

    @GetMapping
    public List<Stock> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Stock save(@RequestBody Stock stock) {
        return repository.save(stock);
    }
}
