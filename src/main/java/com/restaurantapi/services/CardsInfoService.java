package com.restaurantapi.services;


import com.restaurantapi.models.CardsInfo;
import com.restaurantapi.repositories.CardsInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CardsInfoService {

    private final CardsInfoRepository cardsInfoRepository;

    public CardsInfoService(CardsInfoRepository cardsInfoRepository) {
        this.cardsInfoRepository = cardsInfoRepository;
    }

    public List<CardsInfo> findAll() {
        return cardsInfoRepository.findAll();
    }

    public CardsInfo findById(Long id) {
        return cardsInfoRepository.getById(id);
    }

    public CardsInfo getById(Long id) {
        return cardsInfoRepository.getById(id);
    }

    public List<CardsInfo> getAll() {
        return cardsInfoRepository.findAll();
    }

    public CardsInfo create(CardsInfo cardsInfo) {
        return cardsInfoRepository.save(cardsInfo);
    }

    public CardsInfo update(CardsInfo cardsInfo) {
        CardsInfo foundCardsInfo = cardsInfoRepository.getById(cardsInfo.getId());
        if (cardsInfo.getName() != null) {
            foundCardsInfo.setName(cardsInfo.getName());
        }
        return cardsInfoRepository.save(cardsInfo);
    }

    public CardsInfo deleteById(Long id) {
        CardsInfo cardsInfo = cardsInfoRepository.getById(id);
        if (cardsInfo != null) {
            cardsInfoRepository.deleteById(id);
            return cardsInfo;
        }
        return cardsInfo;

    }

    public String delete(long id) {

        cardsInfoRepository.deleteById(id);
        return "SUCCESS";
    }


}
