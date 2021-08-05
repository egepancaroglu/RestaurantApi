package com.restaurantapi.models.dto;

import com.restaurantapi.models.entity.Address;
import com.restaurantapi.models.entity.County;
import lombok.Data;

@Data
public class CityDTO {

    private Long id;
    private String name;
    private Address address;
    private County county;


    public void setAddress(AddressDTO convert) {
    }

    public void setCounty(CountyDTO convert) {
    }
}
