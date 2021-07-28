package com.example.demo.controllers;

import com.example.demo.models.City;
import com.example.demo.services.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("city")

public class CityController {


    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }


    @PostMapping
    public ResponseEntity<City> create(@RequestBody City city) {
        return new ResponseEntity(cityService.create(city), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<City>> getAll() {
        return new ResponseEntity(cityService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getById(@PathVariable Long id) {
        return new ResponseEntity(cityService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<City> deleteById(@PathVariable Long id) {
        cityService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
