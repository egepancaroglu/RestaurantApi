package com.restaurantapi.services;


import com.restaurantapi.models.Restaurants;
import com.restaurantapi.models.enumerated.Status;
import com.restaurantapi.repositories.RestaurantsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantsService {

    private final RestaurantsRepository restaurantsRepository;

    public RestaurantsService(RestaurantsRepository restaurantsRepository) {
        this.restaurantsRepository = restaurantsRepository;
    }

    public List<Restaurants> findAll() {
        return restaurantsRepository.findAll();
    }

    public Restaurants findById(Long id) {
        return restaurantsRepository.getById(id);
    }

    public List<Restaurants> getAll() {
        return restaurantsRepository.findAll();
    }

    public List<Restaurants> getByStatus(Status status) {
        return restaurantsRepository.findAllByStatus(status);
    }

    public Restaurants create(Restaurants restaurants) {
        return restaurantsRepository.save(restaurants);
    }

    public Restaurants getById(Long id) {
        return restaurantsRepository.getById(id);
    }

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

    public Restaurants deleteById(Long id) {
        Restaurants restaurants = restaurantsRepository.getById(id);
        if (restaurants != null) {
            restaurantsRepository.deleteById(id);
            return restaurants;
        }
        return restaurants;
    }

    public String delete(long id) {

        restaurantsRepository.deleteById(id);
        return "SUCCESS";
    }
}
