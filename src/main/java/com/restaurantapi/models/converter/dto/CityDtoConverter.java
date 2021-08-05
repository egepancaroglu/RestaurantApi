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
public class CityDtoConverter implements GenericConverter<City, CityDTO> {

    private final GenericConverter<Address, AddressDTO> addressDtoConverter;
    private final GenericConverter<County, CountyDTO> countyDtoConverter;

    @Override
    public CityDTO convert(final City city) {
        if (city == null) {
            return null;
        }

        CityDTO city1 = new CityDTO();

        city1.setId(city1.getId());
        city1.setAddress(convert(city1.getAddress()));
        city1.setCounty(convert(city1.getCounty()));
        city1.setName(city1.getName());


        return city1;

    }


    private AddressDTO convert(final Address address) {
        return addressDtoConverter.convert(address);
    }

    private CountyDTO convert(final County county) {
        return countyDtoConverter.convert(county);
    }


}



