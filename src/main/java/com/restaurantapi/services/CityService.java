package com.restaurantapi.services;

import com.restaurantapi.models.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    City create(City city);

    List<City> getAll();

    City getById(Long id);

    City update(City city);

    City deleteById(Long id);

    City findById(Long id);

    String delete(Long id);

    List<City> findAll();

}
