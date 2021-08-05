package com.restaurantapi.models.dto;

import com.restaurantapi.models.entity.Meal;
import lombok.Data;

@Data
public class ItemsDTO {

    private Long id;
    private String name;
    private String unit_type;
    private Meal meal;

    public void setMeal(MealDTO convert) {
    }
}
