package com.restaurantapi.services;

import com.restaurantapi.models.Basket;
import com.restaurantapi.repositories.BasketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {

    private final BasketRepository basketRepository;

    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public List<Basket> findAll() {
        return basketRepository.findAll();
    }

    public Basket findById(Long id) {
        return basketRepository.getById(id);
    }

    public Basket getById(Long id) {
        return basketRepository.getById(id);
    }

    public List<Basket> getAll() {
        return basketRepository.findAll();
    }

    public Basket create(Basket basket) {
        return basketRepository.save(basket);
    }

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

    public Basket deleteById(Long id) {
        Basket basket = basketRepository.getById(id);
        if (basket != null) {
            basketRepository.deleteById(id);
            return basket;
        }
        return basket;
    }

    public String delete(long id) {

        basketRepository.deleteById(id);
        return "SUCCESS";
    }


}
