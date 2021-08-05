package com.restaurantapi.models.dto;

import com.restaurantapi.models.entity.Branch;
import com.restaurantapi.models.entity.Users;
import lombok.Data;

@Data
public class CommentsDTO {

    private Long id;
    private String comment;
    private Integer taste_point;
    private Integer speed_point;
    private Branch branch;
    private Users users;

    public void setBranch(BranchDTO convert) {
    }

    public void setUsers(UsersDTO convert) {
    }
}
