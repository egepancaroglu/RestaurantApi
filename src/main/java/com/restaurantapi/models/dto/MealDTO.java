package com.restaurantapi.models.dto;

import com.restaurantapi.models.entity.Basket;
import com.restaurantapi.models.entity.Items;
import com.restaurantapi.models.entity.Menu;
import lombok.Data;

@Data
public class MealDTO {

    private Long id;
    private String name;
    private Float price;
    private String Item;
    private Menu menu;
    private Items items;
    private Basket basket;


    public void setMenu(MenuDTO convert) {
    }

    public void setItems(ItemsDTO convert) {
    }

    public void setBasket(BasketDTO convert) {
    }
}
