package com.restaurantapi.controllers;


import com.restaurantapi.models.Sube;
import com.restaurantapi.services.SubeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sube")
public class SubeController {


    private final SubeService subeService;

    public SubeController(SubeService subeService) {
        this.subeService = subeService;
    }

    @PostMapping
    public ResponseEntity<Sube> create(@RequestBody Sube sube) {
        return new ResponseEntity(subeService.create(sube), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Sube>> getAll() {
        return new ResponseEntity(subeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sube> getById(@PathVariable Long id) {
        return new ResponseEntity(subeService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Sube> deleteById(@PathVariable Long id) {
        subeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
