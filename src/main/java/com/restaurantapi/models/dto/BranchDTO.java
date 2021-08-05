package com.restaurantapi.models.dto;

import com.restaurantapi.models.entity.Comments;
import com.restaurantapi.models.entity.Menu;
import com.restaurantapi.models.entity.Restaurants;
import com.restaurantapi.models.enumerated.Role;
import com.restaurantapi.models.enumerated.Status;
import lombok.Data;

@Data
public class BranchDTO {


    private Long id;
    private String name;
    private Status status;
    private Role role;
    private Integer speed_rate;
    private Integer taste_rate;
    private Integer vote_count;
    private Integer comment_count;
    private Menu menu;
    private Comments comments;
    private Restaurants restaurants;

    public void setMenu(MenuDTO convert) {
    }

    public void setRestaurants(RestaurantsDTO convert) {
    }

    public void setComments(CommentsDTO convert) {
    }
}


