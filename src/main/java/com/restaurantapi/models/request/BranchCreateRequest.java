package com.restaurantapi.models.request;

import com.restaurantapi.models.entity.Comments;
import com.restaurantapi.models.entity.Menu;
import com.restaurantapi.models.entity.Restaurants;
import com.restaurantapi.models.enumerated.Role;
import com.restaurantapi.models.enumerated.Status;
import lombok.Data;

import java.util.List;

@Data
public class BranchCreateRequest {

    private Long id;
    private String name;
    private Status status;
    private Role role;
    private Integer speed_rate;
    private Integer taste_rate;
    private Integer vote_count;
    private Integer comment_count;
    private Menu menu;
    private List<Comments> comments;
    private Restaurants restaurants;

}
