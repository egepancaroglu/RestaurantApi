package com.example.demo.controllers;

import com.example.demo.models.Items;
import com.example.demo.services.ItemsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("items")

public class ItemsController {


    private final ItemsService itemsService;

    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }


    @PostMapping
    public ResponseEntity<Items> create(@RequestBody Items items) {
        return new ResponseEntity(itemsService.create(items), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Items>> getAll() {
        return new ResponseEntity(itemsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Items> getById(@PathVariable Long id) {
        return new ResponseEntity(itemsService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Items> deleteById(@PathVariable Long id) {
        itemsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
