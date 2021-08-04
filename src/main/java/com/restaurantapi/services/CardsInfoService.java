package com.restaurantapi.services;


import com.restaurantapi.models.CardsInfo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CardsInfoService {

    CardsInfo create(CardsInfo cardsInfo);

    List<CardsInfo> getAll();

    CardsInfo getById(Long id);

    CardsInfo update(CardsInfo cardsInfo);

    CardsInfo deleteById(Long id);

    CardsInfo findById(Long id);

    String delete(Long id);

    List<CardsInfo> findAll();


}
