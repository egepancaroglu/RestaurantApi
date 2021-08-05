package com.restaurantapi.models.request;

import com.restaurantapi.models.entity.Meal;
import lombok.Data;

import java.util.Set;

@Data
public class ItemsCreateRequest {

    private Long id;
    private String name;
    private String unit_type;
    private Set<Meal> meal;
}
