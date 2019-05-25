package com.restaurant.garlix.controller;

import com.restaurant.garlix.entity.Item;
import com.restaurant.garlix.entity.OrderItem;
import com.restaurant.garlix.entity.Orders;
import com.restaurant.garlix.entity.User;
import com.restaurant.garlix.exception.ItemNotFoundException;
import com.restaurant.garlix.repository.ItemRepository;
import com.restaurant.garlix.repository.OrderItemRepository;
import com.restaurant.garlix.repository.OrdersRepository;
import com.restaurant.garlix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/order")
public class OrderController {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    UserRepository userRepository;


    @PostMapping
    public Orders createOrder(@Valid @RequestBody Orders orders) {

        User user = userRepository.findById(orders.getUser_id())
                .orElseThrow(() -> new ItemNotFoundException("User", "id", orders.getUser_id()));
        orders.setUser(user);

        for (Map.Entry<Long, Integer> entry : orders.getItems().entrySet()) {
            Item item = itemRepository.findById(entry.getKey())
                    .orElseThrow(() -> new ItemNotFoundException("Item", "id", entry.getKey()));
            orders.setTotal_price(orders.getTotal_price() + (item.getPrice() * entry.getValue()));
            orderItemRepository.save(new OrderItem(orders,item,entry.getValue()));
        }

        return ordersRepository.save(orders);

    }


}