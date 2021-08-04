package com.restaurantapi.services;

import com.restaurantapi.models.Users;
import com.restaurantapi.models.enumerated.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService {

    Users create(Users users);

    List<Users> getAll();

    Users getById(Long id);

    Users update(Users users);

    Users deleteById(Long id);

    Users findById(Long id);

    List<Users> findAll();

    String delete(Long id);

    List<Users> getByStatus(Status status);

    Users getUserByName(String name);


}
