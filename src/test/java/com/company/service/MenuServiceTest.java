package com.company.service;

import com.company.entity.Dish;
import com.company.repository.DishRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
public class MenuServiceTest {

    @Autowired
    private MenuService menuService;

    @MockBean
    private DishRepository dishRepository;

    @Test
    public void getMenu() {
        when(dishRepository.findAll()).thenReturn(Stream.of(
                new Dish("hey",200.0,"df","df","df")).
                collect(Collectors.toList()));
        assertEquals(1, menuService.getMenu().size());
    }
}