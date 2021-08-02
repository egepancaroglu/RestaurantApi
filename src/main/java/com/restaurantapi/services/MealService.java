package com.restaurantapi.services;

import com.restaurantapi.models.Meal;
import com.restaurantapi.repositories.MealRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    private final MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public List<Meal> findAll() {
        return mealRepository.findAll();
    }

    public Meal findById(Long id) {
        return mealRepository.getById(id);
    }

    public Meal getById(Long id) {
        return mealRepository.getById(id);
    }

    public Meal create(Meal meal) {
        return mealRepository.save(meal);
    }

    public List<Meal> getAll() {
        return mealRepository.findAll();
    }


    public Meal update(Meal meal) {
        Meal foundMeal = mealRepository.getById(meal.getId());
        if (meal.getName() != null) {
            foundMeal.setName(meal.getName());
        }
        if (meal.getPrice() != null) {
            foundMeal.setName(meal.getName());
        }
        return mealRepository.save(meal);
    }

    public Meal deleteById(Long id) {
        Meal meal = mealRepository.getById(id);
        if (meal != null) {
            mealRepository.deleteById(id);
            return meal;
        }
        return meal;
    }

    public String delete(long id) {

        mealRepository.deleteById(id);
        return "SUCCESS";
    }


}
