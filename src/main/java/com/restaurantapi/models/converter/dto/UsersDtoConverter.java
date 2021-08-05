package com.restaurantapi.models.converter.dto;


import com.restaurantapi.models.converter.GenericConverter;
import com.restaurantapi.models.dto.*;
import com.restaurantapi.models.entity.*;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class UsersDtoConverter implements GenericConverter<Users, UsersDTO> {

    private final GenericConverter<Address, AddressDTO> addressesDtoConverter;
    private final GenericConverter<CardsInfo, CardsInfoDTO> cardsInfoDtoConverter;
    private final GenericConverter<Comments, CommentsDTO> commentsDtoConverter;
    private final GenericConverter<Restaurants, RestaurantsDTO> restaurantsDtoConverter;
    private final GenericConverter<Basket, BasketDTO> basketDtoConverter;

    @Override
    public UsersDTO convert(final Users users) {
        if (users == null) {
            return null;
        }

        UsersDTO users1 = new UsersDTO();

        users1.setId(users1.getId());
        users1.setName(users1.getName());
        users1.setEmail(users1.getEmail());
        users1.setPassword(users1.getPassword());
        users1.setAddresses(convert(users1.getAddresses()));
        users1.setBasket(convert(users1.getBasket()));
        users1.setCardsInfo(convert(users1.getCardsInfo()));
        users1.setComments(convert(users1.getComments()));
        users1.setRestaurants(convert(users1.getRestaurants()));


        return users1;

    }


    private AddressDTO convert(final Address addresses) {
        return addressesDtoConverter.convert(addresses);
    }

    private CardsInfoDTO convert(final CardsInfo cardsInfo) {
        return cardsInfoDtoConverter.convert(cardsInfo);
    }

    private CommentsDTO convert(final Comments comments) {
        return commentsDtoConverter.convert(comments);
    }

    private RestaurantsDTO convert(final Restaurants restaurants) {
        return restaurantsDtoConverter.convert(restaurants);
    }

    private BasketDTO convert(final Basket basket) {
        return basketDtoConverter.convert(basket);
    }


}




