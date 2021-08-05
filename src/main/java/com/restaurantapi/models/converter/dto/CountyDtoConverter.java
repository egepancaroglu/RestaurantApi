package com.restaurantapi.models.converter.dto;


import com.restaurantapi.models.converter.GenericConverter;
import com.restaurantapi.models.dto.AddressDTO;
import com.restaurantapi.models.dto.CityDTO;
import com.restaurantapi.models.dto.CountyDTO;
import com.restaurantapi.models.entity.Address;
import com.restaurantapi.models.entity.City;
import com.restaurantapi.models.entity.County;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class CountyDtoConverter implements GenericConverter<County, CountyDTO> {

    private final GenericConverter<Address, AddressDTO> addressDtoConverter;
    private final GenericConverter<City, CityDTO> cityDtoConverter;

    @Override
    public CountyDTO convert(final County county) {
        if (county == null) {
            return null;
        }

        CountyDTO county1 = new CountyDTO();

        county1.setId(county1.getId());
        county1.setAddress(convert(county1.getAddress()));
        county1.setCity(convert(county1.getCity()));
        county1.setName(county1.getName());


        return county1;

    }


    private AddressDTO convert(final Address address) {
        return addressDtoConverter.convert(address);
    }

    private CityDTO convert(final City city) {
        return cityDtoConverter.convert(city);
    }


}




