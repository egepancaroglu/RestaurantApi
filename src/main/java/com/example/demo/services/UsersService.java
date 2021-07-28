package com.example.demo.services;

import com.example.demo.models.Users;
import com.example.demo.repositories.UsersRepository;
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

    public Users update(Users users) {
        Users update = usersRepository.getById((long) users.getId());
        if (update != null) {
            usersRepository.save(users);
            return update;
        }
        return users;

    }

    public void deleteById(Long id) {
        usersRepository.deleteById(id);
    }


}
