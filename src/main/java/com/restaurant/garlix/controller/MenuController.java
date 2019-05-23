package com.restaurant.garlix.controller;

import com.restaurant.garlix.entity.Item;
import com.restaurant.garlix.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/menu")
public class MenuController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping
    public List<Item> getMenu() {
        // Todo: Implement function to get menu and return
        return itemRepository.findAll();
    }

    @PostMapping
    public void createOrder() {
        // Todo: Implement function for creating order
        return;

    }
}