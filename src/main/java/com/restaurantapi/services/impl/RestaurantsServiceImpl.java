package com.restaurantapi.services.impl;

import com.restaurantapi.models.Restaurants;
import com.restaurantapi.models.enumerated.Status;
import com.restaurantapi.repositories.RestaurantsRepository;
import com.restaurantapi.services.RestaurantsService;

import java.util.List;

public class RestaurantsServiceImpl implements RestaurantsService {


    private final RestaurantsRepository restaurantsRepository;


    public RestaurantsServiceImpl(RestaurantsRepository restaurantsRepository) {
        this.restaurantsRepository = restaurantsRepository;
    }

    @Override
    public List<Restaurants> findAll() {
        return restaurantsRepository.findAll();
    }

    @Override
    public Restaurants findById(Long id) {
        return restaurantsRepository.getById(id);
    }

    @Override
    public List<Restaurants> getAll() {
        return restaurantsRepository.findAll();
    }

    @Override
    public List<Restaurants> getByStatus(Status status) {
        return restaurantsRepository.findAllByStatus(status);
    }

    @Override
    public Restaurants create(Restaurants restaurants) {
        return restaurantsRepository.save(restaurants);
    }

    @Override
    public Restaurants getById(Long id) {
        return restaurantsRepository.getById(id);
    }

    @Override
    public Restaurants update(Restaurants restaurants) {
        Restaurants foundRestaurants = restaurantsRepository.getById(restaurants.getId());
        if (restaurants.getStatus() != null) {
            foundRestaurants.setStatus(restaurants.getStatus());
        }
        if (restaurants.getName() != null) {
            foundRestaurants.setName(restaurants.getName());
        }
        return restaurantsRepository.save(restaurants);
    }

    @Override
    public Restaurants deleteById(Long id) {
        Restaurants restaurants = restaurantsRepository.getById(id);
        if (restaurants != null) {
            restaurantsRepository.deleteById(id);
            return restaurants;
        }
        return restaurants;
    }

    @Override
    public String delete(Long id) {

        restaurantsRepository.deleteById(id);
        return "SUCCESS";
    }
}
