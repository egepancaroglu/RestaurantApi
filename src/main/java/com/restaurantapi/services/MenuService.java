package com.restaurantapi.services;


import com.restaurantapi.models.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService {

    Menu create(Menu menu);

    List<Menu> getAll();

    Menu getById(Long id);

    Menu update(Menu menu);

    Menu deleteById(Long id);

    Menu findById(Long id);

    String delete(Long id);

    List<Menu> findAll();

}
