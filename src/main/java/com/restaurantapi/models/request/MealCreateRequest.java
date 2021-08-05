package com.restaurantapi.models.request;

import com.restaurantapi.models.entity.Basket;
import com.restaurantapi.models.entity.Items;
import com.restaurantapi.models.entity.Menu;
import lombok.Data;

@Data
public class MealCreateRequest {

    private Long id;
    private String name;
    private Float price;
    private String Item;
    private Menu menu;
    private Items items;
    private Basket basket;

}
