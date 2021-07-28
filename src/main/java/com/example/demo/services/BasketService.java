package com.example.demo.services;

import com.example.demo.models.Basket;
import com.example.demo.repositories.BasketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {

    private final BasketRepository basketRepository;

    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public List<Basket> findAll() { return basketRepository.findAll(); }

    public Basket findById(Long id) { return basketRepository.getById(id); }

    public Basket create(Basket basket) { return basketRepository.save(basket); }

    public Basket update(Basket basket){
        Basket update = basketRepository.getById((long) basket.getId());
        if(update != null) {
            basketRepository.save(basket);
            return update;
        }
        return basket;
    }

    public void deleteById(Long id){
        basketRepository.deleteById(id);
    }



}
