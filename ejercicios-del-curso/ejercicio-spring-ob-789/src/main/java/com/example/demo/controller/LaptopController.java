package com.example.demo.controller;


import com.example.demo.entity.Laptop;
import com.example.demo.repository.LaptopRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository){ this.laptopRepository = laptopRepository;}

    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){ return laptopRepository.findAll();}

    @GetMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        return laptopOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping("/api/laptops")
    public Laptop create (@RequestBody Laptop laptop){
        
        return laptopRepository.save(laptop);
    }




}
