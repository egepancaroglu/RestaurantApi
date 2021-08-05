package com.restaurantapi.repositories;

import com.restaurantapi.models.entity.Users;
import com.restaurantapi.models.enumerated.Status;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends BaseRepository<Users> {
    List<Users> findAllByStatus(Status status);

    Users findByName(String name);

}
