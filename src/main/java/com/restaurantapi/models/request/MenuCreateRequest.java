package com.restaurantapi.models.request;

import com.restaurantapi.models.entity.County;
import com.restaurantapi.models.entity.Meal;
import com.restaurantapi.models.entity.Menu;
import lombok.Data;

import java.util.List;

@Data
public class MenuCreateRequest {

    private Long id;
    private String enable;
    private String Meal;
    private County county;
    private Menu menu;
    private List<Meal> menulist;
}
