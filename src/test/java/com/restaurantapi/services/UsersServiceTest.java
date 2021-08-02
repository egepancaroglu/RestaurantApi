package com.restaurantapi.services;

import com.restaurantapi.models.Users;
import com.restaurantapi.models.enumerated.Role;
import com.restaurantapi.repositories.UsersRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UsersServiceTest {
    private static final Role ROLE = Role.USER;
    private static final Role ROLENEW = Role.SELLER;
    private static final String PASSWORD = "1234";
    private static final String PASSWORDNEW = "1234567";

    @InjectMocks
    private UsersService usersService;

    @Mock
    private UsersRepository usersRepository;


    @Test
    public void ReturnAllUsers() {
        Users users1 = Users.builder().id(1L).build();
        Users users2 = Users.builder().id(2L).build();
        List<Users> usersList = Arrays.asList(users1, users2);

        Mockito.when(usersRepository.findAll()).thenReturn(usersList);

        List<Users> fetchedList = usersService.getAll();

        assertEquals(usersList.size(), fetchedList.size());
    }

    @Test
    public void ReturnUsers() {
        Users users = Users.builder().id(1L).password(PASSWORD).build();

        Mockito.when(usersRepository.getById(1L)).thenReturn(users);

        Users fetchedUsers = usersService.getById(1L);

        assertEquals(users.getId(), fetchedUsers.getId());
    }

    @Test
    public void ReturnSavedUsers() {
        Users users = Users.builder().build();

        Mockito.doReturn(users).when(usersRepository).save(users);

        Users returnedUsers = usersService.create(users);


    }

    @Test
    public void ReturnUpdatedUsers() {
        Users existUsers = Users.builder().id(1L).role(ROLE).build();
        Users newUsers = Users.builder().id(1L).role(ROLENEW).build();
        Mockito.when(usersRepository.getById(1L)).thenReturn(existUsers);
        Mockito.when(usersRepository.save(newUsers)).thenReturn(newUsers);
        Users updatedUsers = usersService.update(newUsers);
        Assertions.assertNotEquals(existUsers.getRole(), ROLE);
        Assertions.assertEquals(existUsers.getRole(), ROLENEW);

    }
}
