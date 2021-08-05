package com.restaurantapi.models.request;

import com.restaurantapi.models.entity.Meal;
import com.restaurantapi.models.entity.Order;
import com.restaurantapi.models.entity.Users;
import lombok.Data;

@Data
public class BasketCreateRequest {

    private Long id;
    private Integer count;
    private Double totalPrice;
    private Users users;
    private Order order;
    private Meal meal;

}

