package com.restaurantapi.models.converter.dto;


import com.restaurantapi.models.converter.GenericConverter;
import com.restaurantapi.models.dto.BasketDTO;
import com.restaurantapi.models.dto.OrderDTO;
import com.restaurantapi.models.entity.Basket;
import com.restaurantapi.models.entity.Order;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class OrderDtoConverter implements GenericConverter<Order, OrderDTO> {

    private final GenericConverter<Basket, BasketDTO> basketDtoConverter;

    @Override
    public OrderDTO convert(final Order order) {
        if (order == null) {
            return null;
        }

        OrderDTO order1 = new OrderDTO();

        order1.setId(order1.getId());
        order1.setAmount(order1.getAmount());
        order1.setDate(order1.getDate());
        order1.setBasket(convert(order1.getBasket()));


        return order1;

    }


    private BasketDTO convert(final Basket basket) {
        return basketDtoConverter.convert(basket);
    }


}




