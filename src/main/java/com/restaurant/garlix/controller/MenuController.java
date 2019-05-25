package com.restaurant.garlix.controller;

import com.restaurant.garlix.entity.Item;
import com.restaurant.garlix.exception.ItemNotFoundException;
import com.restaurant.garlix.repository.ItemRepository;
import com.restaurant.garlix.repository.OrderItemRepository;
import com.restaurant.garlix.repository.OrdersRepository;
import com.restaurant.garlix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/menu")
public class MenuController {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<Item> getMenu(@RequestParam(value = "active", required = false, defaultValue = "")  Boolean active) {
        if (active == null){
            return itemRepository.findAll();
        }else if (active == true){
            return itemRepository.findByStatus(true);
        }else {
            return itemRepository.findByStatus(false);
        }
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable(value = "id") Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item", "id", id));
    }

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
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item", "id", id));
        itemRepository.delete(item);
        return ResponseEntity.ok().build();
    }
}