package com.restaurantapi.models.request;

import com.restaurantapi.models.entity.Address;
import com.restaurantapi.models.entity.City;
import lombok.Data;

@Data
public class CountyCreateRequest {

    private Long id;
    private String name;
    private Address address;
    private City city;

}
