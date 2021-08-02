package com.restaurantapi.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurantapi.models.Items;
import com.restaurantapi.repositories.ItemsRepository;
import com.restaurantapi.services.ItemsService;
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
@WebMvcTest(value = ItemsController.class)
public class ItemsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ItemsService itemsService;

    @MockBean
    ItemsRepository itemsRepository;

    String mapToJson(Object o) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(o);
    }

    @Test
    public void add() throws Exception {

        Items items = this.generateItem();

        String URI = "/items";
        String inputJson = this.mapToJson(items);

        Mockito.when(itemsService.update(Mockito.any(Items.class))).thenReturn(items);

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
    public void getAll() throws Exception {

        List<Items> itemsList = new ArrayList<>();
        itemsList.add(this.generateItem());

        String URI = "/items";
        String inputJson = this.mapToJson(itemsList);

        Mockito.when(itemsService.getAll()).thenReturn(itemsList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertThat("").isEqualTo(outputJson);
    }

    @Test
    public void getById() throws Exception {

        Items items = this.generateItem();

        String URI = "/items/11";
        String inputJson = this.mapToJson(items);

        Mockito.when(itemsService.getById(Mockito.anyLong())).thenReturn(items);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertThat("").isEqualTo(outputJson);
    }

    @Test
    public void update() throws Exception {

        Items items = this.generateItem();

        String URI = "/items";
        String inputJson = this.mapToJson(items);

        Mockito.when(itemsService.update(Mockito.any(Items.class))).thenReturn(items);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputJson)
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertThat("").isEqualTo(outputJson);
    }

    @Test
    public void delete() throws Exception {

        Items items = this.generateItem();

        String URI = "/items/6";

        Mockito.when(itemsService.delete(Mockito.anyLong())).thenReturn("success");

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete(URI)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertThat("").isEqualTo(outputJson);
    }

    private Items generateItem() {
        return Items.builder()
                .name("Patlıcak Musakka")
                .build();
    }
}