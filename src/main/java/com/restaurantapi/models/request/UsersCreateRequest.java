package com.restaurantapi.models.request;

import com.restaurantapi.models.entity.*;
import com.restaurantapi.models.enumerated.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UsersCreateRequest {

    private Long id;
    private String email;
    private String password;
    private String enabled;
    private Role role;
    private String name;
    private Set<Address> addresses;
    private Set<CardsInfo> cardsInfo;
    private Set<Comments> comments;
    private Restaurants restaurants;
    private Basket basket;

}
