package com.restaurantapi.models.dto;

import com.restaurantapi.models.entity.*;
import com.restaurantapi.models.enumerated.Role;
import lombok.Data;

@Data
public class UsersDTO {

    private Long id;
    private String email;
    private String password;
    private String enabled;
    private Role role;
    private String name;
    private Address addresses;
    private CardsInfo cardsInfo;
    private Comments comments;
    private Restaurants restaurants;
    private Basket basket;


    public void setAddress(UsersDTO convert) {
    }

    public void setBasket(BasketDTO convert) {
    }

    public void setCardsInfo(CardsInfoDTO convert) {
    }

    public void setComments(CommentsDTO convert) {
    }

    public void setRestaurants(RestaurantsDTO convert) {

    }

    public void setAddresses(AddressDTO convert) {
    }
}
