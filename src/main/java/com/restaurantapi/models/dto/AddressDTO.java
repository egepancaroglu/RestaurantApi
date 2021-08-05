package com.restaurantapi.models.dto;


import com.restaurantapi.models.entity.Branch;
import com.restaurantapi.models.entity.City;
import com.restaurantapi.models.entity.County;
import com.restaurantapi.models.entity.Users;
import lombok.Data;

@Data
public class AddressDTO {

    private Long id;
    private City city;
    private County county;
    private Users users;
    private Branch branch;
    private String district;
    private String other_content;

    public Object getOtherContent() {
        return other_content;
    }

    public void setOtherContent(Object otherContent) {
    }

    public void setCity(CityDTO convert) {
    }

    public void setCounty(CountyDTO convert) {
    }

    public void setUsers(UsersDTO convert) {
    }

    public void setBranch(BranchDTO convert) {
    }
}
