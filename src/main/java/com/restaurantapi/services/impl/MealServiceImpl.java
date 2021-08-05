package com.restaurantapi.services.impl;

import com.restaurantapi.models.entity.Meal;
import com.restaurantapi.repositories.MealRepository;
import com.restaurantapi.services.MealService;

import java.util.List;

public class MealServiceImpl implements MealService {


    private final MealRepository mealRepository;

    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public List<Meal> findAll() {
        return mealRepository.findAll();
    }

    @Override
    public Meal findById(Long id) {
        return mealRepository.getById(id);
    }

    @Override
    public Meal getById(Long id) {
        return mealRepository.getById(id);
    }

    @Override
    public Meal create(Meal meal) {
        return mealRepository.save(meal);
    }

    @Override
    public List<Meal> getAll() {
        return mealRepository.findAll();
    }

    @Override
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

    @Override
    public Meal deleteById(Long id) {
        Meal meal = mealRepository.getById(id);
        if (meal != null) {
            mealRepository.deleteById(id);
            return meal;
        }
        return meal;
    }

    @Override
    public String delete(Long id) {

        mealRepository.deleteById(id);
        return "SUCCESS";
    }
}
