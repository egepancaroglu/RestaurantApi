package com.example.demo.controllers;

import com.example.demo.models.Restaurants;
import com.example.demo.services.RestaurantsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("restaurants")
public class RestaurantsController {


    private final RestaurantsService restaurantsService;

    public RestaurantsController(RestaurantsService restaurantsService) {
        this.restaurantsService = restaurantsService;
    }


    @PostMapping
    public ResponseEntity<Restaurants> create(@RequestBody Restaurants restaurants) {
        return new ResponseEntity(restaurantsService.create(restaurants), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Restaurants>> getAll() {
        return new ResponseEntity(restaurantsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurants> getById(@PathVariable Long id) {
        return new ResponseEntity(restaurantsService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Restaurants> deleteById(@PathVariable Long id) {
        restaurantsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
