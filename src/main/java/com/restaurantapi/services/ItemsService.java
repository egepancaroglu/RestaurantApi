package com.restaurantapi.services;

import com.restaurantapi.models.Items;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemsService {

    Items create(Items items);

    List<Items> getAll();

    Items getById(Long id);

    Items update(Items items);

    Items deleteById(Long id);

    Items findById(Long id);

    String delete(Long id);

    List<Items> findAll();

}
