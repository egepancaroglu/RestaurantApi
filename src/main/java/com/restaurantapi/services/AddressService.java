package com.restaurantapi.services;


import com.restaurantapi.models.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    Address create(Address address);

    List<Address> getAll();

    Address getById(Long id);

    Address update(Address address);

    Address deleteById(Long id);

    Address findById(Long id);

    List<Address> findAll();









}

