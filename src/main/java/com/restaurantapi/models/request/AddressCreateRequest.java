package com.restaurantapi.models.request;

import com.restaurantapi.models.entity.Branch;
import com.restaurantapi.models.entity.City;
import com.restaurantapi.models.entity.County;
import com.restaurantapi.models.entity.Users;
import lombok.Data;


@Data
public class AddressCreateRequest {

        private Long id;
        private String name;
        private City city;
        private County county;
        private Users user;
        private Branch branch;
        private String district;
        private String otherContent;
        private Boolean enable;

}
