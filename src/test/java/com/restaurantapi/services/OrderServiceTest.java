package com.restaurantapi.services;

import com.restaurantapi.models.entity.Order;
import com.restaurantapi.repositories.OrderRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
    @InjectMocks
    private OrderService orderService;
    @Mock
    private OrderRepository orderRepository;

    @Test
    public void ReturnAllOrder() {
        Order order1 = Order.builder().id(1l).build();
        Order order2 = Order.builder().id(2l).build();

        List<Order> commentList = Arrays.asList(order1, order2);
        Mockito.when(orderRepository.findAll()).thenReturn(commentList);

        List<Order> fetchedList = orderService.findAll();
        assertEquals(commentList.size(), fetchedList.size());
    }

    @Test
    public void ReturnOrder() {
        Order order = Order.builder().amount(3).build();

        Mockito.when(orderRepository.getById(1L)).thenReturn(order);

        Order fetchedOrder = orderService.findById(1L);

        assertEquals(order.getId(), fetchedOrder.getId());
    }

    @Test
    public void ReturnSavedOrder() {
        Order order = Order.builder().amount(2).build();
        Mockito.doReturn(order).when(orderRepository).save(order);

        Order returnedOrder = orderService.create(order);

        assertEquals(order.getAmount(), returnedOrder.getAmount());
    }

    @Test
    public void ReturnUpdatedOrder() {
        Order existOrder = Order.builder().id(1L).amount(2).build();
        Order newOrder = Order.builder().id(1L).amount(3).build();

        Mockito.when(orderRepository.getById(1L)).thenReturn(existOrder);
        Mockito.when(orderRepository.save(newOrder)).thenReturn(newOrder);

        Order updatedOrder = orderService.update(newOrder);
        Assertions.assertNotEquals(existOrder.getAmount(), 2);
        Assertions.assertEquals(existOrder.getAmount(), 3);

    }


}
