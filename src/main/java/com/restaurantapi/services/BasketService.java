package com.restaurantapi.services;

import com.restaurantapi.models.entity.Basket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BasketService {
    Basket create(Basket basket);

    List<Basket> getAll();

    Basket getById(Long id);

    Basket update(Basket basket);

    Basket deleteById(Long id);

    Basket findById(Long id);

    List<Basket> findAll();

    String delete(Long id);


}
