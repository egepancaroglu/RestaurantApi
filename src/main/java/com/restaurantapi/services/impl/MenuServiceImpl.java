package com.restaurantapi.services.impl;

import com.restaurantapi.models.entity.Menu;
import com.restaurantapi.repositories.MenuRepository;
import com.restaurantapi.services.MenuService;

import java.util.List;

public class MenuServiceImpl implements MenuService {


    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    @Override
    public Menu findById(Long id) {
        return menuRepository.getById(id);
    }

    @Override
    public Menu create(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu getById(Long id) {
        return menuRepository.getById(id);
    }

    @Override
    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    @Override
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

    @Override
    public Menu deleteById(Long id) {
        Menu menu = menuRepository.getById(id);
        if (menu != null) {
            menuRepository.deleteById(id);
            return menu;
        }
        return menu;

    }

    @Override
    public String delete(Long id) {

        menuRepository.deleteById(id);
        return "SUCCESS";
    }
}
