package com.restaurantapi.services;

import com.restaurantapi.models.entity.Menu;
import com.restaurantapi.repositories.MenuRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MenuServiceTest {
    @InjectMocks
    private MenuService menuService;
    @Mock
    private MenuRepository menuRepository;

    @Test
    public void whenFetchAll_thenReturnAllMenu() {
        Menu menu1 = Menu.builder().id(1l).build();
        Menu menu2 = Menu.builder().id(2l).build();

        List<Menu> commentList = Arrays.asList(menu1, menu2);
        Mockito.when(menuRepository.findAll()).thenReturn(commentList);

        List<Menu> fetchedList = menuService.findAll();
        assertEquals(commentList.size(), fetchedList.size());
    }

    @Test
    public void whenFetchById_thenReturnMenu() {
        Menu menu = Menu.builder().Meal("Burger").build();

        Mockito.when(menuRepository.getById(1L)).thenReturn(menu);

        Menu fetchedMenu = menuService.findById(1L);

        assertEquals(menu.getId(), fetchedMenu.getId());
    }

    @Test
    public void whenAddMenu_thenReturnSavedMenu() {
        Menu menu = Menu.builder().Meal("Burger").build();
        Mockito.doReturn(menu).when(menuRepository).save(menu);

        Menu returnedMenu = menuService.create(menu);

        assertEquals(menu.getMeal(), returnedMenu.getMeal());
    }

    @Test
    public void whenUpdateMenu_thenReturnUpdatedMenu() {
        Menu existMenu = Menu.builder().id(1L).Meal("Tavuk").build();
        Menu newMenu = Menu.builder().id(1L).Meal("Burger").build();

        Mockito.when(menuRepository.getById(1L)).thenReturn(existMenu);
        Mockito.when(menuRepository.save(newMenu)).thenReturn(newMenu);

        Menu updatedMenu = menuService.update(newMenu);
        Assertions.assertNotEquals(existMenu.getMeal(), "Tavuk");
        Assertions.assertEquals(existMenu.getMeal(), "Burger");

    }
}