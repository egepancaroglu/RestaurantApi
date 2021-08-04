package com.restaurantapi.controllers;


import com.restaurantapi.models.Branch;
import com.restaurantapi.models.enumerated.Status;
import com.restaurantapi.services.BranchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sube")
public class BranchController {


    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @PostMapping
    public ResponseEntity<Branch> create(@RequestBody Branch branch) {
        return new ResponseEntity(branchService.create(branch), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Branch>> getAll() {
        return new ResponseEntity(branchService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Branch> getById(@PathVariable Long id) {
        return new ResponseEntity(branchService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/waiting")
    public ResponseEntity<List<Branch>> getWaiting() {
        return new ResponseEntity(branchService.getByStatus(Status.WAITING), HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<Branch> update(@RequestBody Branch branch) {
        return new ResponseEntity(branchService.update(branch), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Branch> deleteById(@PathVariable Long id) {
        branchService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
