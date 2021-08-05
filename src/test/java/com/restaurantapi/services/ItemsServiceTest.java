package com.restaurantapi.services;


import com.restaurantapi.models.entity.Items;
import com.restaurantapi.repositories.ItemsRepository;
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
public class ItemsServiceTest {

    private static final String InitStatus = "Pizza";
    private static final String NewStatus = "PizzaTost";

    @InjectMocks
    private ItemsService itemsService;

    @Mock
    private ItemsRepository itemsRepository;

    @Test
    public void ReturnAllItem() {
        Items items1 = Items.builder().id(1l).name("Pizza").build();
        Items items2 = Items.builder().id(2l).name("PizzaTost").build();
        List<Items> itemsList = Arrays.asList(items1, items2);
        Mockito.when(itemsRepository.findAll()).thenReturn(itemsList);
        List<Items> fetchedList = itemsService.getAll();
        assertEquals(itemsList.size(), fetchedList.size());
    }

    @Test
    public void ReturnItemById() {
        Items item = Items.builder().name("Pizza").build();
        Mockito.when(itemsRepository.getById(1L)).thenReturn(item);
        Items fetchedBasket = itemsService.getById(1L);
        assertEquals(item.getId(), fetchedBasket.getId());
    }

    @Test
    public void ReturnSavedItem() {
        Items item = Items.builder().name("Pizza").build();
        Mockito.doReturn(item).when(itemsRepository).save(item);
        Items returnedItem = itemsService.create(item);
        assertEquals(item.getName(), returnedItem.getName());
    }

    @Test
    public void ReturnUpdatedItem() {
        Items existItem = Items.builder().id(1L).name(InitStatus).build();
        Items newItem = Items.builder().id(1L).name(NewStatus).build();
        Mockito.when(itemsRepository.getById(1L)).thenReturn(existItem);
        Mockito.when(itemsRepository.save(newItem)).thenReturn(newItem);
        Items updatedBasket = itemsService.update(newItem);
        Assertions.assertEquals(existItem.getName(), NewStatus);
        Assertions.assertNotEquals(existItem.getName(), InitStatus);
    }
}

