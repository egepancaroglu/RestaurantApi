package com.restaurantapi.services;

import com.restaurantapi.models.entity.Basket;
import com.restaurantapi.repositories.BasketRepository;
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
public class BasketServiceTest {

    private static final Double TOTAL_PRICE = 115.23;
    private static final Double TOTAL_PRICENEW = 118.65;
    private static final Integer COUNT = 2;
    private static final Integer COUNTNEW = 3;

    @InjectMocks
    private BasketService basketService;

    @Mock
    private BasketRepository basketRepository;


    @Test
    public void ReturnAllBasket() {
        Basket basket1 = Basket.builder().id(1L).build();
        Basket basket2 = Basket.builder().id(2L).build();
        List<Basket> basketList = Arrays.asList(basket1, basket2);

        Mockito.when(basketRepository.findAll()).thenReturn(basketList);

        List<Basket> fetchedList = basketService.getAll();

        assertEquals(basketList.size(), fetchedList.size());
    }

    @Test
    public void ReturnBasket() {
        Basket basket = Basket.builder().id(1L).totalPrice(160.59).build();

        Mockito.when(basketRepository.getById(1L)).thenReturn(basket);

        Basket fetchedBasket = basketService.getById(1L);

        assertEquals(basket.getId(), fetchedBasket.getId());
    }

    @Test
    public void ReturnSavedBasket() {
        Basket basket = Basket.builder().build();

        Mockito.doReturn(basket).when(basketRepository).save(basket);

        Basket returnedBasket = basketService.create(basket);


    }

    @Test
    public void ReturnUpdatedBasket() {
        Basket existBasket = Basket.builder().id(1L).count(2).totalPrice(TOTAL_PRICE).build();
        Basket newBasket = Basket.builder().id(1L).count(2).totalPrice(TOTAL_PRICENEW).build();
        Mockito.when(basketRepository.getById(1L)).thenReturn(existBasket);
        Mockito.when(basketRepository.save(newBasket)).thenReturn(newBasket);
        Basket updatedBasket = basketService.update(newBasket);
        Assertions.assertNotEquals(existBasket.getTotalPrice(), TOTAL_PRICE);
        Assertions.assertNotEquals(existBasket.getCount(), COUNT);
        Assertions.assertEquals(existBasket.getTotalPrice(), TOTAL_PRICENEW);
        Assertions.assertEquals(existBasket.getCount(), COUNTNEW);
    }
}
