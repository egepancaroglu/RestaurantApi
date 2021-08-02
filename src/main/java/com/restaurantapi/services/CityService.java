package com.restaurantapi.services;

import com.restaurantapi.models.City;
import com.restaurantapi.repositories.CityRepository;
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

    public City getById(Long id) {
        return cityRepository.getById(id);
    }

    public List<City> getAll() {
        return cityRepository.findAll();
    }

    public City create(City city) {
        return cityRepository.save(city);
    }

    public City update(City city) {
        City foundCity = cityRepository.getById(city.getId());
        if (city.getName() != null) {
            foundCity.setName(city.getName());
        }
        return cityRepository.save(city);
    }

    public City deleteById(Long id) {
        City city = cityRepository.getById(id);
        if (city != null) {
            cityRepository.deleteById(id);
            return city;
        }
        return city;
    }

    public String delete(long id) {

        cityRepository.deleteById(id);
        return "SUCCESS";
    }

}
