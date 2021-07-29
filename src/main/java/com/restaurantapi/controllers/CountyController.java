package com.restaurantapi.controllers;

import com.restaurantapi.models.County;
import com.restaurantapi.services.CountyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("county")
public class CountyController {


    private final CountyService countyService;

    public CountyController(CountyService countyService) {
        this.countyService = countyService;
    }


    @PostMapping
    public ResponseEntity<County> create(@RequestBody County county) {
        return new ResponseEntity(countyService.create(county), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<County>> getAll() {
        return new ResponseEntity(countyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<County> getById(@PathVariable Long id) {
        return new ResponseEntity(countyService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<County> deleteById(@PathVariable Long id) {
        countyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
