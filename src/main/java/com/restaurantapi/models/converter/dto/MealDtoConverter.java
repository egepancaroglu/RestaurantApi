package com.restaurantapi.models.converter.dto;


import com.restaurantapi.models.converter.GenericConverter;
import com.restaurantapi.models.dto.BasketDTO;
import com.restaurantapi.models.dto.ItemsDTO;
import com.restaurantapi.models.dto.MealDTO;
import com.restaurantapi.models.dto.MenuDTO;
import com.restaurantapi.models.entity.Basket;
import com.restaurantapi.models.entity.Items;
import com.restaurantapi.models.entity.Meal;
import com.restaurantapi.models.entity.Menu;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class MealDtoConverter implements GenericConverter<Meal, MealDTO> {

    private final GenericConverter<Menu, MenuDTO> menuDtoConverter;
    private final GenericConverter<Items, ItemsDTO> itemsDtoConverter;
    private final GenericConverter<Basket, BasketDTO> basketDtoConverter;

    @Override
    public MealDTO convert(final Meal meal) {
        if (meal == null) {
            return null;
        }

        MealDTO meal1 = new MealDTO();

        meal1.setId(meal1.getId());
        meal1.setName(meal1.getName());
        meal1.setPrice(meal1.getPrice());
        meal1.setItem(meal1.getItem());
        meal1.setMenu(convert(meal1.getMenu()));
        meal1.setBasket(convert(meal1.getBasket()));


        return meal1;

    }


    private MenuDTO convert(final Menu menu) {
        return menuDtoConverter.convert(menu);
    }

    private ItemsDTO convert(final Items items) {
        return itemsDtoConverter.convert(items);
    }

    private BasketDTO convert(final Basket basket) {
        return basketDtoConverter.convert(basket);
    }


}




