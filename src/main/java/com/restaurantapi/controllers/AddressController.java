package com.restaurantapi.controllers;

import com.restaurantapi.models.Address;
import com.restaurantapi.services.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//localhost:8080/address/1
//localhost:8080/address?id=1
//localhost:8080/address {address}
//GET, POST, PUT, DELETE
//PathVariable, RequestParam, RequestBody

@RestController
@RequestMapping("address")
public class AddressController {


    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<Address> create(@RequestBody Address address) {
        return new ResponseEntity(addressService.create(address), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAll() {
        return new ResponseEntity(addressService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getById(@PathVariable Long id) {
        return new ResponseEntity(addressService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Address> deleteById(@PathVariable Long id) {
        addressService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

/////   PostMapping, HttpStatus.Created
}

