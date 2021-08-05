package com.restaurantapi.models.request;

import com.restaurantapi.models.entity.Users;
import com.restaurantapi.models.enumerated.Status;
import lombok.Data;

import java.util.Set;

@Data
public class RestaurantsCreateRequest {

    private Long id;
    private String name;
    private String unit_type;
    private Status status;
    private Set<Users> users;
}
