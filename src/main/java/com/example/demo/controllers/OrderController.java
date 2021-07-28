package com.example.demo.controllers;

import com.example.demo.models.Order;
import com.example.demo.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")

public class OrderController {


    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) {
        return new ResponseEntity(orderService.create(order), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return new ResponseEntity(orderService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable Long id) {
        return new ResponseEntity(orderService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Order> deleteById(@PathVariable Long id) {
        orderService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
