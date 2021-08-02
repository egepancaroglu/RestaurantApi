package com.restaurantapi.services;

import com.restaurantapi.models.Order;
import com.restaurantapi.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.getById(id);
    }

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    public Order getById(Long id) {
        return orderRepository.getById(id);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order update(Order order) {
        Order foundUOrder = orderRepository.getById(order.getId());
        if (order.getAmount() != null) {
            foundUOrder.setAmount(order.getAmount());
        }
        if (order.getDate() != null) {
            foundUOrder.setDate(order.getDate());
        }
        return orderRepository.save(order);
    }

    public Order deleteById(Long id) {
        Order order = orderRepository.getById(id);
        if (order != null) {
            orderRepository.deleteById(id);
            return order;
        }
        return order;

    }

    public String delete(long id) {

        orderRepository.deleteById(id);
        return "SUCCESS";
    }

}
