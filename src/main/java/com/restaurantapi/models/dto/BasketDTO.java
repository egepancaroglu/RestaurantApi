package com.restaurantapi.models.dto;

import com.restaurantapi.models.entity.Meal;
import com.restaurantapi.models.entity.Order;
import com.restaurantapi.models.entity.Users;
import lombok.Data;

@Data
public class BasketDTO {

        private Long id;
        private Integer count;
        private Double totalPrice;
        private Users users;
        private Order order;
        private Meal meal;

        public void setUsers(UsersDTO convert) {

        }
}

