package com.restaurantapi.services;

import com.restaurantapi.models.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    Order create(Order order);

    List<Order> getAll();

    Order getById(Long id);

    Order update(Order order);

    Order deleteById(Long id);

    Order findById(Long id);

    String delete(Long id);

    List<Order> findAll();


}
