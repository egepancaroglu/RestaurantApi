package com.restaurantapi.models.request;

import com.restaurantapi.models.entity.Address;
import com.restaurantapi.models.entity.County;
import lombok.Data;

import java.util.List;

@Data
public class CityCreateRequest {

    private Long id;
    private String name;
    private Address address;
    private List<County> county;
}
