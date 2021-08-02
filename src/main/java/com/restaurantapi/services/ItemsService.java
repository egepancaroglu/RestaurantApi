package com.restaurantapi.services;

import com.restaurantapi.models.Items;
import com.restaurantapi.repositories.ItemsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsService {

    private final ItemsRepository itemsRepository;

    public ItemsService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<Items> findAll(){
        return itemsRepository.findAll();
    }

    public Items findById(Long id) {
        return itemsRepository.getById(id);
    }

    public Items create(Items items) {
        return itemsRepository.save(items);
    }

    public Items getById(Long id) {
        return itemsRepository.getById(id);
    }

    public List<Items> getAll() {
        return itemsRepository.findAll();
    }

    public Items update(Items items) {
        Items foundItems = itemsRepository.getById(items.getId());
        if (items.getName() != null) {
            foundItems.setName(items.getName());
        }
        if (items.getUnit_type() != null) {
            foundItems.setUnit_type(items.getUnit_type());
        }
        return itemsRepository.save(items);
    }

    public Items deleteById(Long id) {
        Items items = itemsRepository.getById(id);
        if (items != null) {
            itemsRepository.deleteById(id);
            return items;
        }
        return items;
    }

    public String delete(long id) {

        itemsRepository.deleteById(id);
        return "SUCCESS";
    }
}
