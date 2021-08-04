package com.restaurantapi.services;

import com.restaurantapi.models.Meal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MealService {

    Meal create(Meal meal);

    List<Meal> getAll();

    Meal getById(Long id);

    Meal update(Meal meal);

    Meal deleteById(Long id);

    Meal findById(Long id);

    String delete(Long id);

    List<Meal> findAll();


}
