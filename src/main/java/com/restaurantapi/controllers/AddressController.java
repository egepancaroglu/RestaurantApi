package com.restaurantapi.controllers;

import com.restaurantapi.models.Address;
import com.restaurantapi.services.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAll() {
        return new ResponseEntity<>(addressService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Address> getAddress(@PathVariable long id) {

        return new ResponseEntity<>(addressService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {

        return new ResponseEntity<>(addressService.update(address), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Address> updateAddress(@RequestBody Address address) {
        return new ResponseEntity<>(addressService.update(address), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable long id) {

        return new ResponseEntity(addressService.deleteById(id), HttpStatus.OK);
    }

}