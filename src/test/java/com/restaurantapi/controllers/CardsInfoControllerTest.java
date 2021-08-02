package com.restaurantapi.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurantapi.models.CardsInfo;
import com.restaurantapi.repositories.CardsInfoRepository;
import com.restaurantapi.services.CardsInfoService;
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
@WebMvcTest(value = CardsInfoController.class)
public class CardsInfoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CardsInfoService cardsInfoService;

    @MockBean
    CardsInfoRepository cardsInfoRepository;

    String mapToJson(Object o) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(o);
    }

    @Test
    public void add() throws Exception {

        CardsInfo cardsInfo = this.generateCardsInfo();

        String URI = "/C-cardsInfo";
        String inputJson = this.mapToJson(cardsInfo);

        Mockito.when(cardsInfoService.update(Mockito.any(CardsInfo.class))).thenReturn(cardsInfo);

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

        List<CardsInfo> CardsInfoList = new ArrayList<>();
        CardsInfoList.add(this.generateCardsInfo());

        String URI = "/cardsInfo";
        String inputJson = this.mapToJson(CardsInfoList);

        Mockito.when(cardsInfoService.getAll()).thenReturn(CardsInfoList);

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

        CardsInfo cardsInfo = this.generateCardsInfo();

        String URI = "/CardsInfo/25";
        String inputJson = this.mapToJson(cardsInfo);

        Mockito.when(cardsInfoService.getById(Mockito.anyLong())).thenReturn(cardsInfo);

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

        CardsInfo cardsInfo = this.generateCardsInfo();

        String URI = "/cardsInfo";
        String inputJson = this.mapToJson(cardsInfo);

        Mockito.when(cardsInfoService.update(Mockito.any(CardsInfo.class))).thenReturn(cardsInfo);

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

        CardsInfo cardsInfo = this.generateCardsInfo();

        String URI = "/cardsInfo/9";

        Mockito.when(cardsInfoService.delete(Mockito.anyLong())).thenReturn("success");

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete(URI)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertThat("").isEqualTo(outputJson);
    }

    private CardsInfo generateCardsInfo() {
        return CardsInfo.builder()
                .name("Ziraat")
                .build();
    }
}

