package com.restaurantapi.controllers;

import com.restaurantapi.models.Restaurants;
import com.restaurantapi.models.Users;
import com.restaurantapi.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {


    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<Users> create(@RequestBody Users users) {
        return new ResponseEntity(usersService.create(users), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAll() {
        return new ResponseEntity(usersService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getById(@PathVariable Long id) {
        return new ResponseEntity(usersService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Restaurants> deleteById(@PathVariable Long id) {
        usersService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
