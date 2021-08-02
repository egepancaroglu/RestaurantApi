package com.restaurantapi.services;


import com.restaurantapi.models.County;
import com.restaurantapi.repositories.CountyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountyService {


    private final CountyRepository countyRepository;

    public CountyService(CountyRepository countyRepository) {
        this.countyRepository = countyRepository;
    }

    public List<County> findAll() {
        return countyRepository.findAll();
    }

    public List<County> getAll() {
        return countyRepository.findAll();
    }

    public County findById(Long id) {
        return countyRepository.getById(id);
    }

    public County getById(Long id) {
        return countyRepository.getById(id);
    }

    public County create(County county) {
        return countyRepository.save(county);
    }

    public County update(County county) {
        County foundCity = countyRepository.getById(county.getId());
        if (county.getName() != null) {
            foundCity.setName(county.getName());
        }
        return countyRepository.save(county);
    }

    public County deleteById(Long id) {
        County county = countyRepository.getById(id);
        if (county != null) {
            countyRepository.deleteById(id);
            return county;
        }
        return county;
    }

    public String delete(long id) {

        countyRepository.deleteById(id);
        return "SUCCESS";
    }
}
