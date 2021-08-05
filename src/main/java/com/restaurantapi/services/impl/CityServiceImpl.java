package com.restaurantapi.services.impl;

import com.restaurantapi.models.entity.City;
import com.restaurantapi.repositories.CityRepository;
import com.restaurantapi.services.CityService;

import java.util.List;

public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(Long id) {
        return cityRepository.getById(id);
    }

    @Override
    public City getById(Long id) {
        return cityRepository.getById(id);
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public City create(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City update(City city) {
        City foundCity = cityRepository.getById(city.getId());
        if (city.getName() != null) {
            foundCity.setName(city.getName());
        }
        return cityRepository.save(city);
    }

    @Override
    public City deleteById(Long id) {
        City city = cityRepository.getById(id);
        if (city != null) {
            cityRepository.deleteById(id);
            return city;
        }
        return city;
    }

    @Override
    public String delete(Long id) {

        cityRepository.deleteById(id);
        return "SUCCESS";
    }

}
