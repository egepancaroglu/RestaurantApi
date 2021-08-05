package com.restaurantapi.models.converter.dto;


import com.restaurantapi.models.converter.GenericConverter;
import com.restaurantapi.models.dto.CardsInfoDTO;
import com.restaurantapi.models.dto.UsersDTO;
import com.restaurantapi.models.entity.CardsInfo;
import com.restaurantapi.models.entity.Users;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class CardsInfoDtoConverter implements GenericConverter<CardsInfo, CardsInfoDTO> {

    private final GenericConverter<Users, UsersDTO> userDtoConverter;


    @Override
    public CardsInfoDTO convert(final CardsInfo cardsInfo) {
        if (cardsInfo == null) {
            return null;
        }

        CardsInfoDTO cardsInfo1 = new CardsInfoDTO();

        cardsInfo1.setId(cardsInfo1.getId());
        cardsInfo1.setUsers(convert(cardsInfo1.getUsers()));


        return cardsInfo1;

    }


    private UsersDTO convert(final Users users) {
        return userDtoConverter.convert(users);
    }


}

