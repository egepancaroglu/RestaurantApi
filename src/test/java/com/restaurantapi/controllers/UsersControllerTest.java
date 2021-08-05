package com.restaurantapi.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurantapi.models.entity.Users;
import com.restaurantapi.models.enumerated.Role;
import com.restaurantapi.repositories.UsersRepository;
import com.restaurantapi.services.UsersService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = UsersController.class)
public class UsersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsersService usersService;

    @MockBean
    private UsersRepository usersRepository;


    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    @Test
    public void addUser() throws Exception {

        Users users = this.generateUsers();

        String URI = "/users";
        String inputJson = this.mapToJson(users);

        Mockito.when(usersService.update(Mockito.any(Users.class))).thenReturn(users);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertThat("").isEqualTo(outputJson);


    }

    @Test
    public void getAllUsers() throws Exception {

        List<Users> userList = new ArrayList<>();
        userList.add(this.generateUsers());

        String URI = "/users";
        String inputInJson = this.mapToJson(userList);

        Mockito.when(usersService.getAll()).thenReturn(userList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputInJson = response.getContentAsString();

        Assertions.assertThat(outputInJson).isEqualTo("");


    }

    @org.junit.Test
    public void getUserById() throws Exception {

        Users users = this.generateUsers();

        String URI = "/users/1";
        String inputJson = this.mapToJson(users);

        Mockito.when(usersService.getById(Mockito.anyLong())).thenReturn(users);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String outputJsonValue = result.getResponse().getContentAsString();

        Assertions.assertThat("").isEqualTo(outputJsonValue);


    }

    @org.junit.Test
    public void getUserByName() throws Exception {

        Users users = this.generateUsers();

        String URI = "/users/name/test";
        String inputJson = this.mapToJson(users);

        Mockito.when(usersService.getUserByName(Mockito.anyString())).thenReturn(users);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJsonValue = response.getContentAsString();

        Assertions.assertThat("").isEqualTo(outputJsonValue);
    }

    @org.junit.Test
    public void updateUsers() throws Exception {

        Users users = this.generateUsers();

        String URI = "/users";
        String inputJson = this.mapToJson(users);

        Mockito.when(usersService.update(Mockito.any(Users.class))).thenReturn(users);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put(URI)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON).content(this.mapToJson(users));

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJsonValue = response.getContentAsString();

        Assertions.assertThat("").isEqualTo(outputJsonValue);
    }

    @org.junit.Test
    public void deleteUsers() throws Exception {

        Users users = this.generateUsers();

        String URI = "/users/1";

        Mockito.when(usersService.delete(Mockito.anyLong())).thenReturn("success");

        RequestBuilder request = MockMvcRequestBuilders
                .delete(URI)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJsonValue = response.getContentAsString();

        Assertions.assertThat("").isEqualTo(outputJsonValue);
    }

    private Users generateUsers() {
        return Users.builder()
                .name("testname")
                .email("test@mail.com")
                .role(Role.ADMIN)
                .build();
    }
}
