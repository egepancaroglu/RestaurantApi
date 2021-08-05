package com.restaurantapi.models.converter.dto;


import com.restaurantapi.models.converter.GenericConverter;
import com.restaurantapi.models.dto.CountyDTO;
import com.restaurantapi.models.dto.MealDTO;
import com.restaurantapi.models.dto.MenuDTO;
import com.restaurantapi.models.entity.County;
import com.restaurantapi.models.entity.Meal;
import com.restaurantapi.models.entity.Menu;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class MenuDtoConverter implements GenericConverter<Menu, MenuDTO> {

    private final GenericConverter<County, CountyDTO> countyDtoConverter;
    private final GenericConverter<Meal, MealDTO> menulistDtoConverter;


    @Override
    public MenuDTO convert(final Menu menu) {
        if (menu == null) {
            return null;
        }

        MenuDTO menu1 = new MenuDTO();

        menu1.setId(menu1.getId());
        menu1.setEnable(menu1.getEnable());
        menu1.setMeal(menu1.getMeal());
        menu1.setCounty(convert(menu1.getCounty()));
        menu1.setMenulist(convert(menu1.getMenulist()));


        return menu1;

    }


    private CountyDTO convert(final County county) {
        return countyDtoConverter.convert(county);
    }

    private MealDTO convert(final Meal meal) {
        return menulistDtoConverter.convert(meal);
    }


}




