package com.restaurantapi.services;


import com.restaurantapi.models.Address;
import com.restaurantapi.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address findById(Long id) {
        return addressRepository.getById(id);
    }

    public Address create(Address address) {
        return addressRepository.save(address);
    }

    public Address getById(Long id) {
        return addressRepository.getById(id);
    }

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public Address update(Address address) {
        Address foundAddress = addressRepository.getById(address.getId());
        if (address.getCounty() != null) {
            foundAddress.setCounty(address.getCounty());
        }
        if (address.getDistrict() != null) {
            foundAddress.setDistrict(address.getDistrict());
        }
        if (address.getOther_content() != null) {
            foundAddress.setOther_content(address.getOther_content());
        }
        return addressRepository.save(address);
    }

    public Address deleteById(Long id) {
        Address address = addressRepository.getById(id);
        if (address != null) {
            addressRepository.deleteById(id);
            return address;
        }
        return address;
    }
}

