package com.restaurantapi.services.impl;

import com.restaurantapi.models.Address;
import com.restaurantapi.repositories.AddressRepository;
import com.restaurantapi.services.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {


    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.getById(id);
    }

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address getById(Long id) {
        return addressRepository.getById(id);
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
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

    @Override
    public Address deleteById(Long id) {
        Address address = addressRepository.getById(id);
        if (address != null) {
            addressRepository.deleteById(id);
            return address;
        }
        return address;
    }
}
