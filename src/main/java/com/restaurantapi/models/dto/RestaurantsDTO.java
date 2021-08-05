package com.restaurantapi.models.dto;

import com.restaurantapi.models.entity.Users;
import com.restaurantapi.models.enumerated.Status;
import lombok.Data;

@Data
public class RestaurantsDTO {

    private Long id;
    private String name;
    private String unit_type;
    private Status status;
    private Users users;

    public void setUsers(UsersDTO convert) {
    }
}
