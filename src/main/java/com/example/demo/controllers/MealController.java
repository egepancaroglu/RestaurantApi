package com.example.demo.controllers;

import com.example.demo.models.Meal;
import com.example.demo.services.MealService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("meal")

public class MealController {


    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }


    @PostMapping
    public ResponseEntity<Meal> create(@RequestBody Meal meal) {
        return new ResponseEntity(mealService.create(meal), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Meal>> getAll() {
        return new ResponseEntity(mealService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meal> getById(@PathVariable Long id) {
        return new ResponseEntity(mealService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Meal> deleteById(@PathVariable Long id) {
        mealService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
