package com.restaurantapi.models.converter.dto;


import com.restaurantapi.models.converter.GenericConverter;
import com.restaurantapi.models.dto.BasketDTO;
import com.restaurantapi.models.dto.UsersDTO;
import com.restaurantapi.models.entity.Basket;
import com.restaurantapi.models.entity.Users;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class BasketDtoConverter implements GenericConverter<Basket, BasketDTO> {

    private final GenericConverter<Users, UsersDTO> userDtoConverter;

    @Override
    public BasketDTO convert(final Basket basket) {
        if (basket == null) {
            return null;
        }

        BasketDTO basket1 = new BasketDTO();

        basket1.setId(basket1.getId());

        basket1.setUsers(convert(basket1.getUsers()));

        return basket1;

    }


    private UsersDTO convert(final Users users) {
        return userDtoConverter.convert(users);
    }


}


