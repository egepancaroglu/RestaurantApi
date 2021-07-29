package com.restaurantapi.services;


import com.restaurantapi.models.Menu;
import com.restaurantapi.repositories.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {


    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }


    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    public Menu findById(Long id) {
        return menuRepository.getById(id);
    }

    public Menu create(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu update(Menu menu) {
        Menu update = menuRepository.getById((long) menu.getId());
        if (update != null) {
            menuRepository.save(menu);
            return update;
        }
        return menu;
    }

    public void deleteById(Long id) {
        menuRepository.deleteById(id);
    }
}
