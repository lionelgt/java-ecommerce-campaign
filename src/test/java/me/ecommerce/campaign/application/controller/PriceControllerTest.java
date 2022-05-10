package me.ecommerce.campaign.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import me.ecommerce.campaign.application.dto.PriceRequest;
import me.ecommerce.campaign.domain.service.PriceService;
import me.ecommerce.campaign.infrastructure.dao.entity.PriceEntity;
import me.ecommerce.campaign.infrastructure.dao.jpa.PriceRepositoryJpa;


@Slf4j
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PriceControllerTest {

    @Autowired
    private PriceRepositoryJpa priceRepositoryJpa;
    @Autowired
    private PriceService priceService;
    private MockMvc mockMvc;
    private ObjectMapper mapper;
    
    
    @BeforeAll
    void before(){
        mockMvc = MockMvcBuilders.standaloneSetup(new PriceController(priceService)).build();
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        loadDate();
    }

    @Test
    void findPrice_1() throws Exception {
        PriceRequest priceRequest = PriceRequest
                .builder()
                .productId(35455L)
                .brandId(1L)
                .applicationDate(LocalDateTime.parse("2020-06-14 10:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/price")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(mapper.writeValueAsString(priceRequest));        
        this.mockMvc.perform(requestBuilder)
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.50));
    }
    @Test
    void findPrice_2() throws Exception {
        PriceRequest priceRequest = PriceRequest
                .builder()
                .productId(35455L)
                .brandId(1L)
                .applicationDate(LocalDateTime.parse("2020-06-14 16:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/price")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(mapper.writeValueAsString(priceRequest));
        this.mockMvc.perform(requestBuilder)
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(25.45));
    }
    @Test
    void findPrice_3() throws Exception {
        PriceRequest priceRequest = PriceRequest
                .builder()
                .productId(35455L)
                .brandId(1L)
                .applicationDate(LocalDateTime.parse("2020-06-14 21:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/price")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(mapper.writeValueAsString(priceRequest));
        this.mockMvc.perform(requestBuilder)
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.50));
    }
    @Test
    void findPrice_4() throws Exception {
        PriceRequest priceRequest = PriceRequest
                .builder()
                .productId(35455L)
                .brandId(1L)
                .applicationDate(LocalDateTime.parse("2020-06-15 10:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/price")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(mapper.writeValueAsString(priceRequest));
        this.mockMvc.perform(requestBuilder)
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(30.50));
    }
    @Test
    void findPrice_5() throws Exception {
        PriceRequest priceRequest = PriceRequest
                .builder()
                .productId(35455L)
                .brandId(1L)
                .applicationDate(LocalDateTime.parse("2020-06-16 21:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/price")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(mapper.writeValueAsString(priceRequest));
        this.mockMvc.perform(requestBuilder)
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(38.95));
    }

    private void loadDate(){
        PriceEntity priceOne = PriceEntity.builder()
                                       .brandId(1L)
                                       .startDate(LocalDateTime.parse("2020-06-14 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                                       .endDate(LocalDateTime.parse("2020-12-31 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                                       .productId(35455L)
                                       .priority(0L)
                                       .price(BigDecimal.valueOf(35.50))
                                       .currencyType("EUR")
                                       .build();
        PriceEntity priceTwo = PriceEntity.builder()
                                          .brandId(1L)
                                          .startDate(LocalDateTime.parse("2020-06-14 15:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                                          .endDate(LocalDateTime.parse("2020-06-14 18:30:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                                          .productId(35455L)
                                          .priority(1L)
                                          .price(BigDecimal.valueOf(25.45))
                                          .currencyType("EUR")
                                          .build();
        PriceEntity priceThree = PriceEntity.builder()
                                          .brandId(1L)
                                          .startDate(LocalDateTime.parse("2020-06-15 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                                          .endDate(LocalDateTime.parse("2020-06-15 11:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                                          .productId(35455L)
                                          .priority(1L)
                                          .price(BigDecimal.valueOf(30.50))
                                          .currencyType("EUR")
                                          .build();
        PriceEntity priceOFour = PriceEntity.builder()
                                          .brandId(1L)
                                          .startDate(LocalDateTime.parse("2020-06-15 16:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                                          .endDate(LocalDateTime.parse("2020-12-31 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                                          .productId(35455L)
                                          .priority(1L)
                                          .price(BigDecimal.valueOf(38.95))
                                          .currencyType("EUR")
                                          .build();
        priceRepositoryJpa.saveAll(List.of(priceOne,priceTwo, priceThree, priceOFour));
    }
}
