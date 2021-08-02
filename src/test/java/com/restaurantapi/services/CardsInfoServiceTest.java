package com.restaurantapi.services;

import com.restaurantapi.models.CardsInfo;
import com.restaurantapi.repositories.CardsInfoRepository;
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
public class CardsInfoServiceTest {
    private static final String NAME = "Ziraat";
    private static final String NAMENEW = "Garanti";

    @InjectMocks
    private CardsInfoService cardsInfoService;

    @Mock
    private CardsInfoRepository cardsInfoRepository;


    @Test
    public void ReturnAllCardsInfo() {
        CardsInfo cardsInfo1 = CardsInfo.builder().id(1L).build();
        CardsInfo cardsInfo2 = CardsInfo.builder().id(2L).build();
        List<CardsInfo> cardsInfoList = Arrays.asList(cardsInfo1, cardsInfo2);

        Mockito.when(cardsInfoRepository.findAll()).thenReturn(cardsInfoList);

        List<CardsInfo> fetchedList = cardsInfoService.getAll();

        assertEquals(cardsInfoList.size(), fetchedList.size());
    }

    @Test
    public void ReturnCardsInfo() {
        CardsInfo cardsInfo = CardsInfo.builder().id(1L).name(NAME).build();

        Mockito.when(cardsInfoRepository.getById(1L)).thenReturn(cardsInfo);

        CardsInfo fetchedCardsInfo = cardsInfoService.getById(1L);

        assertEquals(cardsInfo.getId(), fetchedCardsInfo.getId());
    }

    @Test
    public void ReturnSavedCardsInfo() {
        CardsInfo cardsInfo = CardsInfo.builder().build();

        Mockito.doReturn(cardsInfo).when(cardsInfoRepository).save(cardsInfo);

        CardsInfo returnedCardsInfo = cardsInfoService.create(cardsInfo);


    }

    @Test
    public void ReturnUpdatedCardsInfo() {
        CardsInfo existCardsInfo = CardsInfo.builder().id(1L).name(NAME).build();
        CardsInfo newCardsInfo = CardsInfo.builder().id(1L).name(NAMENEW).build();
        Mockito.when(cardsInfoRepository.getById(1L)).thenReturn(existCardsInfo);
        Mockito.when(cardsInfoRepository.save(newCardsInfo)).thenReturn(newCardsInfo);
        CardsInfo updatedCardsInfo = cardsInfoService.update(newCardsInfo);
        Assertions.assertNotEquals(existCardsInfo.getName(), NAME);
        Assertions.assertEquals(existCardsInfo.getName(), NAMENEW);

    }

}
