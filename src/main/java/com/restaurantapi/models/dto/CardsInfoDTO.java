package com.restaurantapi.models.dto;

import com.restaurantapi.models.entity.Users;
import lombok.Data;

import java.time.Month;
import java.time.Year;

@Data
public class CardsInfoDTO {

    private Long id;
    private Integer card_no;
    private String name;
    private Year exp_year;
    private Month exp_month;
    private Users users;
    private Integer ccv;

    public void setUsers(UsersDTO convert) {
    }
}
