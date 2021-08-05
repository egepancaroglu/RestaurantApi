package com.restaurantapi.services;

import com.restaurantapi.models.entity.Restaurants;
import com.restaurantapi.models.enumerated.Status;
import com.restaurantapi.repositories.RestaurantsRepository;
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
public class RestaurantServiceTest {

    private static final Status InitStatus = Status.WAITING;
    private static final Status NewStatus = Status.APPROVED;

    @InjectMocks
    private RestaurantsService restaurantsService;

    @Mock
    private RestaurantsRepository restaurantsRepository;

    @Test
    public void ReturnAllRestaurant() {
        Restaurants restaurants1 = Restaurants.builder().id(1l).build();
        Restaurants restaurants2 = Restaurants.builder().id(2l).build();
        List<Restaurants> commentList = Arrays.asList(restaurants1, restaurants2);

        Mockito.when(restaurantsRepository.findAll()).thenReturn(commentList);

        List<Restaurants> fetchedList = restaurantsService.findAll();

        assertEquals(commentList.size(), fetchedList.size());
    }

    @Test
    public void ReturnRestaurant() {
        Restaurants restaurants = Restaurants.builder().status(Status.APPROVED).build();

        Mockito.when(restaurantsRepository.getById(1L)).thenReturn(restaurants);

        Restaurants fetchedRestaurant = restaurantsService.findById(1L);

        assertEquals(restaurants.getId(), fetchedRestaurant.getId());
    }

    @Test
    public void ReturnSavedRestaurant() {
        Restaurants restaurants = Restaurants.builder().status(Status.APPROVED).build();
        Mockito.doReturn(restaurants).when(restaurantsRepository).save(restaurants);
        Restaurants returnedRestaurant = restaurantsService.create(restaurants);
        assertEquals(restaurants.getStatus(), returnedRestaurant.getStatus());
    }

    @Test
    public void ReturnUpdatedRestaurant() {
        Restaurants existRestaurants = Restaurants.builder().id(1L).status(InitStatus).build();
        Restaurants newRestaurants = Restaurants.builder().id(1L).status(NewStatus).build();

        Mockito.when(restaurantsRepository.getById(1L)).thenReturn(existRestaurants);
        Mockito.when(restaurantsRepository.save(newRestaurants)).thenReturn(newRestaurants);

        Restaurants updatedRestaurants = restaurantsService.update(newRestaurants);
        Assertions.assertNotEquals(existRestaurants.getStatus(), InitStatus);
        Assertions.assertEquals(existRestaurants.getStatus(), NewStatus);

    }
}