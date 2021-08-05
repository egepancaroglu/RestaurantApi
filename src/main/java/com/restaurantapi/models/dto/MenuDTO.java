package com.restaurantapi.models.dto;

import com.restaurantapi.models.entity.County;
import com.restaurantapi.models.entity.Meal;
import com.restaurantapi.models.entity.Menu;
import lombok.Data;

@Data
public class MenuDTO {

    private Long id;
    private String enable;
    private String Meal;
    private County county;
    private Menu menu;
    private Meal menulist;

    public void setCounty(CountyDTO convert) {
    }

    public void setMenulist(MealDTO convert) {
    }
}
