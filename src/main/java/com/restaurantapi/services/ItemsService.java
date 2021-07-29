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

    public Items update(Items items){
        Items update = itemsRepository.getById((long) items.getId());
        if(update != null) {
            itemsRepository.save(items);
            return update;
        }
        return items;
    }

    public void deleteById(Long id){
        itemsRepository.deleteById(id);
    }
}
