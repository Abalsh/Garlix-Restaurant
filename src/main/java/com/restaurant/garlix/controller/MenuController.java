package com.restaurant.garlix.controller;

import com.restaurant.garlix.entity.Item;
import com.restaurant.garlix.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/menu")
public class MenuController {

    @GetMapping
    public void getMenu() {
        // Todo: Implement function to get menu and return
        return;
    }

    @PostMapping
    public void createOrder() {
        // Todo: Implement function for creating order
        return;

    }
}