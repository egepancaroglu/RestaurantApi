package com.restaurantapi.models.dto;

import com.restaurantapi.models.entity.Basket;
import lombok.Data;

import java.util.Date;

@Data
public class OrderDTO {

    private Long id;
    private Integer amount;
    private Date date;
    private Basket basket;

    public void setBasket(BasketDTO convert) {
    }
}
