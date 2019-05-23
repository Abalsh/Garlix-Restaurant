package com.restaurant.garlix.controller;

import com.restaurant.garlix.entity.Item;
import com.restaurant.garlix.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
public class ItemController {
    @Autowired
    ItemRepository itemRepository;

    @PostMapping("/v1/item")
    public Item createItem(@Valid @RequestBody Item item){
        return itemRepository.save(item);
    }
}
