package com.restaurantapi.models.dto;

import com.restaurantapi.models.entity.Address;
import com.restaurantapi.models.entity.City;
import lombok.Data;

@Data
public class CountyDTO {

    private Long id;
    private String name;
    private Address address;
    private City city;

    public void setAddress(AddressDTO convert) {
    }

    public void setCity(CityDTO convert) {
    }
}
