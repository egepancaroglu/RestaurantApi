package com.restaurantapi.services.impl;

import com.restaurantapi.models.Users;
import com.restaurantapi.models.enumerated.Status;
import com.restaurantapi.repositories.UsersRepository;
import com.restaurantapi.services.UsersService;

import java.util.List;

public class UsersServiceImpl implements UsersService {


    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users findById(Long id) {
        return usersRepository.getById(id);
    }

    @Override
    public Users create(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public Users getById(Long id) {
        return usersRepository.getById(id);
    }

    @Override
    public List<Users> getByStatus(Status status) {
        return usersRepository.findAllByStatus(status);
    }

    @Override
    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users getUserByName(String name) {

        return usersRepository.findByName(name);
    }

    @Override
    public Users update(Users users) {
        Users foundUsers = usersRepository.getById(users.getId());
        if (users.getPassword() != null) {
            foundUsers.setPassword(users.getPassword());
        }
        if (users.getEnabled() != null) {
            foundUsers.setEnabled(users.getEnabled());
        }
        if (users.getRole() != null) {
            foundUsers.setRole(users.getRole());
        }
        return usersRepository.save(users);
    }

    @Override
    public Users deleteById(Long id) {
        Users users = usersRepository.getById(id);
        if (users != null) {
            usersRepository.deleteById(id);
            return users;
        }
        return users;

    }

    @Override
    public String delete(Long id) {

        usersRepository.deleteById(id);
        return "SUCCESS";
    }
}
