package com.restaurantapi.services.impl;

import com.restaurantapi.models.entity.County;
import com.restaurantapi.repositories.CountyRepository;
import com.restaurantapi.services.CountyService;

import java.util.List;

public class CountyServiceImpl implements CountyService {


    private final CountyRepository countyRepository;


    public CountyServiceImpl(CountyRepository countyRepository) {
        this.countyRepository = countyRepository;
    }

    @Override
    public List<County> findAll() {
        return countyRepository.findAll();
    }

    @Override
    public List<County> getAll() {
        return countyRepository.findAll();
    }

    @Override
    public County findById(Long id) {
        return countyRepository.getById(id);
    }

    @Override
    public County getById(Long id) {
        return countyRepository.getById(id);
    }

    @Override
    public County create(County county) {
        return countyRepository.save(county);
    }

    @Override
    public County update(County county) {
        County foundCity = countyRepository.getById(county.getId());
        if (county.getName() != null) {
            foundCity.setName(county.getName());
        }
        return countyRepository.save(county);
    }

    @Override
    public County deleteById(Long id) {
        County county = countyRepository.getById(id);
        if (county != null) {
            countyRepository.deleteById(id);
            return county;
        }
        return county;
    }

    @Override
    public String delete(Long id) {

        countyRepository.deleteById(id);
        return "SUCCESS";
    }

}
