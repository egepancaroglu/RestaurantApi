package com.restaurantapi.services;


import com.restaurantapi.models.entity.Restaurants;
import com.restaurantapi.models.enumerated.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantsService {
    Restaurants create(Restaurants restaurants);

    List<Restaurants> getAll();

    Restaurants getById(Long id);

    Restaurants update(Restaurants restaurants);

    Restaurants deleteById(Long id);

    Restaurants findById(Long id);

    List<Restaurants> findAll();

    String delete(Long id);

    List<Restaurants> getByStatus(Status status);




}
