package com.restaurant.garlix.controller;

import com.restaurant.garlix.entity.Item;
import com.restaurant.garlix.entity.OrderItem;
import com.restaurant.garlix.entity.Orders;
import com.restaurant.garlix.exception.ItemNotFoundException;
import com.restaurant.garlix.repository.ItemRepository;
import com.restaurant.garlix.repository.OrderItemRepository;
import com.restaurant.garlix.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/menu")
public class MenuController {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    OrdersRepository ordersRepository;

    @GetMapping
    public List<Item> getMenu(@RequestParam("active") Boolean active) {
        if (active == true){
            return itemRepository.findByStatus(true);
        }else if (active == false){
            return itemRepository.findByStatus(false);
        }else{
            return itemRepository.findAll();
        }
        //return itemRepository.findByStatus(true);
        //return itemRepository.findAll();
    }
    @GetMapping("/{id}")
    
    public Item getItemById(@PathVariable(value = "id") Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item", "id", id));
    }

    @PostMapping
    public Orders createOrder(@Valid @RequestBody Orders orders) {

        for (Map.Entry<Long, Integer> entry : orders.getItems().entrySet()) {
            Item item = itemRepository.findById(entry.getKey())
                    .orElseThrow(() -> new ItemNotFoundException("Item", "id", entry.getKey()));
            orders.setTotal_price(orders.getTotal_price() + (item.getPrice() * entry.getValue()));
            orderItemRepository.save(new OrderItem(orders,item,entry.getValue()));
        }

        return ordersRepository.save(orders);

    }


}