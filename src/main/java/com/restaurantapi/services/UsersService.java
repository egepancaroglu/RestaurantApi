package com.restaurantapi.services;

import com.restaurantapi.models.Branch;
import com.restaurantapi.models.Users;
import com.restaurantapi.models.enumerated.Status;
import com.restaurantapi.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    public Users findById(Long id) {
        return usersRepository.getById(id);
    }

    public Users create(Users users) {
        return usersRepository.save(users);
    }

    public Users getById(Long id) {
        return usersRepository.getById(id);
    }

    public List<Branch> getByStatus(Status status) {
        return usersRepository.findAllByStatus(status);
    }

    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    public Users getUserByName(String name) {

        return usersRepository.findByName(name);
    }

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

    public Users deleteById(Long id) {
        Users users = usersRepository.getById(id);
        if (users != null) {
            usersRepository.deleteById(id);
            return users;
        }
        return users;

    }

    public String delete(long id) {

        usersRepository.deleteById(id);
        return "SUCCESS";
    }


}
