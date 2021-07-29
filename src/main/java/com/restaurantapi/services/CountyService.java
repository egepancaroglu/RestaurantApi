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

    public List<County> findAll(){
        return countyRepository.findAll();
    }

    public County findById(Long id) {
        return countyRepository.getById(id);
    }

    public County create(County county) {
        return countyRepository.save(county);
    }

    public County update(County county){
        County update = countyRepository.getById((long) county.getId());
        if(update != null) {
            countyRepository.save(county);
            return update;
        }
        return county;
    }

    public void deleteById(Long id){
        countyRepository.deleteById(id);
    }
}
