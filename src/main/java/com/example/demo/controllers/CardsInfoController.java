package com.example.demo.controllers;

import com.example.demo.models.CardsInfo;
import com.example.demo.services.CardsInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("cardsInfo")

public class CardsInfoController {


    private final CardsInfoService cardsInfoService;

    public CardsInfoController(CardsInfoService cardsInfoService) {
        this.cardsInfoService = cardsInfoService;
    }

    @PostMapping
    public ResponseEntity<CardsInfo> create(@RequestBody CardsInfo cardsInfo) {
        return new ResponseEntity(cardsInfoService.create(cardsInfo), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CardsInfo>> getAll() {
        return new ResponseEntity(cardsInfoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardsInfo> getById(@PathVariable Long id) {
        return new ResponseEntity(cardsInfoService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CardsInfo> deleteById(@PathVariable Long id) {
        cardsInfoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
