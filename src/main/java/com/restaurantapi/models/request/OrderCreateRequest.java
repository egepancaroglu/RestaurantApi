package com.restaurantapi.models.request;

import com.restaurantapi.models.entity.Basket;
import lombok.Data;

import java.util.Date;

@Data
public class OrderCreateRequest {

    private Long id;
    private Integer amount;
    private Date date;
    private Basket basket;

}
