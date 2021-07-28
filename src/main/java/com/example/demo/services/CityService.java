package com.example.demo.services;

import com.example.demo.models.City;
import com.example.demo.repositories.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }


    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public City findById(Long id) {
        return cityRepository.getById(id);
    }

    public City create(City city) {
        return cityRepository.save(city);
    }

    public City update(City city) {
        City update = cityRepository.getById((long) city.getId());
        if (update != null) {
            cityRepository.save(city);
            return update;
        }
        return city;
    }

    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }

}
