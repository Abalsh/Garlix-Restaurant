package com.restaurant.garlix.controller;

import com.restaurant.garlix.entity.Item;
import com.restaurant.garlix.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping(value = "/v1/item")
public class ItemController {
    @Autowired
    ItemRepository itemRepository;

    @PostMapping
    public Item createItem(@Valid @RequestBody Item item){
        return itemRepository.save(item);
    }

    @PatchMapping
    public void modifyItem() {
        // Todo: Implement function for modifying item
        return;

    }

    @DeleteMapping
    public void deleteItem() {
        // Todo: Implement function for deleting item
        return;
    }
}