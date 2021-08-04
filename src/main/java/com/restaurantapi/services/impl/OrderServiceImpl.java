package com.restaurantapi.services.impl;

import com.restaurantapi.models.Order;
import com.restaurantapi.repositories.OrderRepository;
import com.restaurantapi.services.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.getById(id);
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.getById(id);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
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

    @Override
    public Order deleteById(Long id) {
        Order order = orderRepository.getById(id);
        if (order != null) {
            orderRepository.deleteById(id);
            return order;
        }
        return order;

    }

    @Override
    public String delete(Long id) {

        orderRepository.deleteById(id);
        return "SUCCESS";
    }
}
