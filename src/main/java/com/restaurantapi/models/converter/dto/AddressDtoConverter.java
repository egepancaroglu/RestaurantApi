package com.restaurantapi.models.converter.dto;

import com.restaurantapi.models.converter.GenericConverter;
import com.restaurantapi.models.dto.*;
import com.restaurantapi.models.entity.*;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class AddressDtoConverter implements GenericConverter<Address, AddressDTO> {

    private final GenericConverter<City, CityDTO> cityDtoConverter;
    private final GenericConverter<County, CountyDTO> countyDtoConverter;
    private final GenericConverter<Users, UsersDTO> userDtoConverter;
    private final GenericConverter<Branch, BranchDTO> branchDtoConverter;

    @Override
    public AddressDTO convert(final Address address) {
        if (address == null) {
            return null;
        }

        AddressDTO address1 = new AddressDTO();

        address1.setId(address.getId());
        address1.setCity(convert(address1.getCity()));
        address1.setCounty(convert(address1.getCounty()));
        address1.setDistrict(address1.getDistrict());
        address1.setOtherContent(address1.getOtherContent());
        address1.setUsers(convert(address1.getUsers()));
        address1.setBranch(convert(address1.getBranch()));

        return address1;

    }

    private CityDTO convert(final City city) {
        return cityDtoConverter.convert(city);
    }

    private CountyDTO convert(final County county) {
        return countyDtoConverter.convert(county);
    }

    private UsersDTO convert(final Users users) {
        return userDtoConverter.convert(users);
    }

    private BranchDTO convert(final Branch branch) {
        return branchDtoConverter.convert(branch);
    }

}

