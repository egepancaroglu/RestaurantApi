package com.restaurantapi.controllers;

import com.restaurantapi.models.Branch;
import com.restaurantapi.models.Restaurants;
import com.restaurantapi.models.enumerated.Status;
import com.restaurantapi.services.RestaurantsService;
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

    @GetMapping("/waiting")
    public ResponseEntity<List<Branch>> getWaiting() {
        return new ResponseEntity(restaurantsService.getByStatus(Status.WAITING), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Restaurants> update(@RequestBody Restaurants restaurants) {
        return new ResponseEntity(restaurantsService.update(restaurants), HttpStatus.OK);
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
    public ResponseEntity deleteById(@PathVariable Long id) {
        restaurantsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
