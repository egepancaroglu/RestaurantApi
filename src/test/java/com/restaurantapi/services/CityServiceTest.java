package com.restaurantapi.services;

import com.restaurantapi.models.City;
import com.restaurantapi.repositories.CityRepository;
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
public class CityServiceTest {
    private static final String CITY_NAME = "Istanbul";
    private static final String CITY_NAMENEW = "Bursa";


    @InjectMocks
    private CityService cityService;

    @Mock
    private CityRepository cityRepository;


    @Test
    public void ReturnAllCity() {
        City City1 = City.builder().id(1L).name(CITY_NAME).build();
        City City2 = City.builder().id(2L).name(CITY_NAMENEW).build();
        List<City> CityList = Arrays.asList(City1, City2);

        Mockito.when(cityRepository.findAll()).thenReturn(CityList);

        List<City> fetchedList = cityService.getAll();

        assertEquals(CityList.size(), fetchedList.size());
    }

    @Test
    public void ReturnCity() {
        City city = City.builder().id(1L).name(CITY_NAME).build();

        Mockito.when(cityRepository.getById(1L)).thenReturn(city);

        City fetchedCity = cityService.getById(1L);

        assertEquals(city.getId(), fetchedCity.getId());
    }

    @Test
    public void ReturnSavedCity() {
        City city = City.builder().build();

        Mockito.doReturn(city).when(cityRepository).save(city);

        City returnedCity = cityService.create(city);


    }

    @Test
    public void ReturnUpdatedCity() {
        City existCity = City.builder().id(1L).name(CITY_NAME).build();
        City newCity = City.builder().id(1L).name(CITY_NAMENEW).build();
        Mockito.when(cityRepository.getById(1L)).thenReturn(existCity);
        Mockito.when(cityRepository.save(newCity)).thenReturn(newCity);
        City updatedCity = cityService.update(newCity);
        Assertions.assertNotEquals(existCity.getName(), CITY_NAME);
        Assertions.assertEquals(existCity.getName(), CITY_NAMENEW);

    }
}
