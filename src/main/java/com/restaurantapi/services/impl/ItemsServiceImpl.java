package com.restaurantapi.services.impl;

import com.restaurantapi.models.Items;
import com.restaurantapi.repositories.ItemsRepository;
import com.restaurantapi.services.ItemsService;

import java.util.List;

public class ItemsServiceImpl implements ItemsService {


    private final ItemsRepository itemsRepository;

    public ItemsServiceImpl(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    @Override
    public List<Items> findAll() {
        return itemsRepository.findAll();
    }

    @Override
    public Items findById(Long id) {
        return itemsRepository.getById(id);
    }

    @Override
    public Items create(Items items) {
        return itemsRepository.save(items);
    }

    @Override
    public Items getById(Long id) {
        return itemsRepository.getById(id);
    }

    @Override
    public List<Items> getAll() {
        return itemsRepository.findAll();
    }

    @Override
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

    @Override
    public Items deleteById(Long id) {
        Items items = itemsRepository.getById(id);
        if (items != null) {
            itemsRepository.deleteById(id);
            return items;
        }
        return items;
    }

    @Override
    public String delete(Long id) {

        itemsRepository.deleteById(id);
        return "SUCCESS";
    }
}
