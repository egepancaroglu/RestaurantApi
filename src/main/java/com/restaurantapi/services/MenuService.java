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

    public Menu getById(Long id) {
        return menuRepository.getById(id);
    }

    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    public Menu update(Menu menu) {
        Menu foundMenu = menuRepository.getById(menu.getId());
        if (menu.getEnable() != null) {
            foundMenu.setEnable(menu.getEnable());
        }
        if (menu.getMeal() != null) {
            foundMenu.setMeal(menu.getMeal());
        }
        return menuRepository.save(menu);
    }

    public Menu deleteById(Long id) {
        Menu menu = menuRepository.getById(id);
        if (menu != null) {
            menuRepository.deleteById(id);
            return menu;
        }
        return menu;

    }

    public String delete(long id) {

        menuRepository.deleteById(id);
        return "SUCCESS";
    }
}
