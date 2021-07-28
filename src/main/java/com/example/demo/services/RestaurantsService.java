package com.example.demo.services;


import com.example.demo.models.Restaurants;
import com.example.demo.repositories.RestaurantsRepository;
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

    public Restaurants create(Restaurants restaurants) {
        return restaurantsRepository.save(restaurants);
    }

    public Restaurants update(Restaurants restaurants) {
        Restaurants update = restaurantsRepository.getById((long) restaurants.getId());
        if (update != null) {
            restaurantsRepository.save(restaurants);
            return update;
        }
        return restaurants;

    }

    public void deleteById(Long id) {
        restaurantsRepository.deleteById(id);
    }
}
