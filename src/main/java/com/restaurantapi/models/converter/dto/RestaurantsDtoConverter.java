package com.restaurantapi.models.converter.dto;


import com.restaurantapi.models.converter.GenericConverter;
import com.restaurantapi.models.dto.RestaurantsDTO;
import com.restaurantapi.models.dto.UsersDTO;
import com.restaurantapi.models.entity.Restaurants;
import com.restaurantapi.models.entity.Users;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class RestaurantsDtoConverter implements GenericConverter<Restaurants, RestaurantsDTO> {

    private final GenericConverter<Users, UsersDTO> usersDtoConverter;

    @Override
    public RestaurantsDTO convert(final Restaurants restaurants) {
        if (restaurants == null) {
            return null;
        }

        RestaurantsDTO restaurants1 = new RestaurantsDTO();

        restaurants1.setId(restaurants1.getId());
        restaurants1.setName(restaurants1.getName());
        restaurants1.setUnit_type(restaurants1.getUnit_type());
        restaurants1.setStatus(restaurants1.getStatus());
        restaurants1.setUsers(convert(restaurants1.getUsers()));


        return restaurants1;

    }


    private UsersDTO convert(final Users users) {
        return usersDtoConverter.convert(users);
    }


}




