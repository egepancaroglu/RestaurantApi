package com.restaurantapi.services;


import com.restaurantapi.models.entity.County;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountyService {

    County create(County county);

    List<County> getAll();

    County getById(Long id);

    County update(County county);

    County deleteById(Long id);

    County findById(Long id);

    String delete(Long id);

    List<County> findAll();

}
