package com.restaurantapi.services.impl;

import com.restaurantapi.models.CardsInfo;
import com.restaurantapi.repositories.CardsInfoRepository;
import com.restaurantapi.services.CardsInfoService;

import java.util.List;

public class CardsInfoServiceImpl implements CardsInfoService {


    private final CardsInfoRepository cardsInfoRepository;

    public CardsInfoServiceImpl(CardsInfoRepository cardsInfoRepository) {
        this.cardsInfoRepository = cardsInfoRepository;
    }

    @Override
    public List<CardsInfo> findAll() {
        return cardsInfoRepository.findAll();
    }

    @Override
    public CardsInfo findById(Long id) {
        return cardsInfoRepository.getById(id);
    }

    @Override
    public CardsInfo getById(Long id) {
        return cardsInfoRepository.getById(id);
    }

    @Override
    public List<CardsInfo> getAll() {
        return cardsInfoRepository.findAll();
    }

    @Override
    public CardsInfo create(CardsInfo cardsInfo) {
        return cardsInfoRepository.save(cardsInfo);
    }

    @Override
    public CardsInfo update(CardsInfo cardsInfo) {
        CardsInfo foundCardsInfo = cardsInfoRepository.getById(cardsInfo.getId());
        if (cardsInfo.getName() != null) {
            foundCardsInfo.setName(cardsInfo.getName());
        }
        return cardsInfoRepository.save(cardsInfo);
    }

    @Override
    public CardsInfo deleteById(Long id) {
        CardsInfo cardsInfo = cardsInfoRepository.getById(id);
        if (cardsInfo != null) {
            cardsInfoRepository.deleteById(id);
            return cardsInfo;
        }
        return cardsInfo;

    }

    @Override
    public String delete(Long id) {

        cardsInfoRepository.deleteById(id);
        return "SUCCESS";
    }
}
