package com.restaurantapi.repositories;

import com.restaurantapi.models.entity.Restaurants;
import com.restaurantapi.models.enumerated.Status;

import java.util.List;

public interface RestaurantsRepository extends BaseRepository<Restaurants> {
    List<Restaurants> findAllByStatus(Status status);

}
