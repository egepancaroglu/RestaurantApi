package com.restaurantapi.models.converter.dto;


import com.restaurantapi.models.converter.GenericConverter;
import com.restaurantapi.models.dto.ItemsDTO;
import com.restaurantapi.models.dto.MealDTO;
import com.restaurantapi.models.entity.Items;
import com.restaurantapi.models.entity.Meal;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class ItemsDtoConverter implements GenericConverter<Items, ItemsDTO> {

    private final GenericConverter<Meal, MealDTO> mealDtoConverter;

    @Override
    public ItemsDTO convert(final Items items) {
        if (items == null) {
            return null;
        }

        ItemsDTO items1 = new ItemsDTO();

        items1.setId(items1.getId());
        items1.setName(items1.getName());
        items1.setUnit_type(items1.getUnit_type());
        items1.setMeal(convert(items1.getMeal()));


        return items1;

    }


    private MealDTO convert(final Meal meal) {
        return mealDtoConverter.convert(meal);
    }


}




