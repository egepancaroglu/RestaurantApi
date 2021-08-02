package com.restaurantapi.repositories;

import com.restaurantapi.models.Branch;
import com.restaurantapi.models.Users;
import com.restaurantapi.models.enumerated.Status;

import java.util.List;


public interface UsersRepository extends BaseRepository<Users> {
    List<Branch> findAllByStatus(Status status);

    Users findByName(String name);

}
