package com.restaurantapi.controllers;


import com.restaurantapi.models.Comments;
import com.restaurantapi.services.CommentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comments")

public class CommentsController {


    private final CommentsService commentsService;


    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @PostMapping
    public ResponseEntity<Comments> create(@RequestBody Comments comments) {
        return new ResponseEntity(commentsService.create(comments), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Comments> update(@RequestBody Comments comments) {
        return new ResponseEntity(commentsService.update(comments), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Comments>> getAll() {
        return new ResponseEntity(commentsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comments> getById(@PathVariable Long id) {
        return new ResponseEntity(commentsService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Comments> deleteById(@PathVariable Long id) {
        commentsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
