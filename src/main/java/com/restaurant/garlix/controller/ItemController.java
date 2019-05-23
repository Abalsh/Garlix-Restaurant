package com.restaurant.garlix.controller;

import com.restaurant.garlix.entity.Item;
import com.restaurant.garlix.exception.ItemNotFoundException;
import com.restaurant.garlix.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/item")
public class ItemController {
    @Autowired
    ItemRepository itemRepository;

    @PostMapping
    public Item createItem(@Valid @RequestBody Item item) {
        return itemRepository.save(item);
    }

    @PatchMapping("/{id}")
    public Item modifyItem(@PathVariable(value = "id") Long id, @Valid @RequestBody Item itemDetails) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item", "id", id));

        item.setName(itemDetails.getName());
        item.setPrice(itemDetails.getPrice());
        item.setDescription(itemDetails.getDescription());
        item.setActive(itemDetails.isActive());

        Item modifiedItem = itemRepository.save(item);
        return modifiedItem;

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable(value = "id") Long id) {
        // Todo: Implement function for deleting item
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item", "id", id));
        itemRepository.delete(item);
        return ResponseEntity.ok().build();


    }
}