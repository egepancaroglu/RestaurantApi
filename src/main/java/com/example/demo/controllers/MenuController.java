package com.example.demo.controllers;


import com.example.demo.models.Menu;
import com.example.demo.services.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("menu")

public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping
    public ResponseEntity<Menu> create(@RequestBody Menu menu) {
        return new ResponseEntity(menuService.create(menu), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Menu>> getAll() {
        return new ResponseEntity(menuService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> getById(@PathVariable Long id) {
        return new ResponseEntity(menuService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Menu> deleteById(@PathVariable Long id) {
        menuService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
