package com.example.demo.controllers;

import com.example.demo.models.Address;
import com.example.demo.services.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        @GetMapping
        public ResponseEntity<List<Address>> getAll(){
            return new ResponseEntity(addressService.findAll(), HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Address> getById(@PathVariable Long id){
            return new ResponseEntity(addressService.findById(id), HttpStatus.OK);
        }

/////   PostMapping, HttpStatus.Created
    }

