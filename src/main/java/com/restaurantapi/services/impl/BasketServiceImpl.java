package com.restaurantapi.services.impl;

import com.restaurantapi.models.Basket;
import com.restaurantapi.repositories.BasketRepository;
import com.restaurantapi.services.BasketService;

import java.util.List;

public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;

    public BasketServiceImpl(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @Override
    public List<Basket> findAll() {
        return basketRepository.findAll();
    }

    @Override
    public Basket findById(Long id) {
        return basketRepository.getById(id);
    }

    @Override
    public Basket getById(Long id) {
        return basketRepository.getById(id);
    }

    @Override
    public List<Basket> getAll() {
        return basketRepository.findAll();
    }

    @Override
    public Basket create(Basket basket) {
        return basketRepository.save(basket);
    }

    @Override
    public Basket update(Basket basket) {
        Basket foundBasket = basketRepository.getById(basket.getId());
        if (basket.getTotalPrice() != null) {
            foundBasket.setTotalPrice(basket.getTotalPrice());
        }
        if (basket.getCount() != null) {
            foundBasket.setCount(basket.getCount());
        }
        return basketRepository.save(basket);
    }

    @Override
    public Basket deleteById(Long id) {
        Basket basket = basketRepository.getById(id);
        if (basket != null) {
            basketRepository.deleteById(id);
            return basket;
        }
        return basket;
    }

    @Override
    public String delete(Long id) {

        basketRepository.deleteById(id);
        return "SUCCESS";
    }
}
