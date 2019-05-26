package com.restaurant.garlix.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private float Total_price;
    private boolean takeaway = true;

    @OneToMany(mappedBy = "orders")
    @JsonIgnore
    private List<OrderItem> orderitems;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private User user;

    transient private Long user_id;
    transient private Map<Long, Integer> items = new HashMap<Long, Integer>();

    public Orders() {
    }

    public Orders(float total_price, boolean takeaway, Long user_id, Map<Long, Integer> items) {
        Total_price = total_price;
        this.takeaway = takeaway;
        this.user_id = user_id;
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getTotal_price() {
        return Total_price;
    }

    public void setTotal_price(float total_price) {
        Total_price = total_price;
    }

    public boolean isTakeaway() {
        return takeaway;
    }

    public void setTakeaway(boolean takeaway) {
        this.takeaway = takeaway;
    }

    public List<OrderItem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(List<OrderItem> orderitems) {
        this.orderitems = orderitems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Map<Long, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Long, Integer> items) {
        this.items = items;
    }
}