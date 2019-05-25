package com.restaurant.garlix.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @NotNull
    private String Client_name;
    @NotNull
    private String Client_address;

    private float Total_price;
    private boolean takeaway = true;

    @OneToOne(mappedBy = "orders")
    private OrderItem orderitem;

    transient private Map<Long, Integer> items = new HashMap<Long, Integer>();

    public Orders(@NotNull String client_name, @NotNull String client_address, float total_price, boolean takeaway, Map<Long, Integer> items) {
        Client_name = client_name;
        Client_address = client_address;
        Total_price = total_price;
        this.takeaway = takeaway;
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClient_name() {
        return Client_name;
    }

    public void setClient_name(String client_name) {
        Client_name = client_name;
    }

    public String getClient_address() {
        return Client_address;
    }

    public void setClient_address(String client_address) {
        Client_address = client_address;
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

    public OrderItem getOrderitem() {
        return orderitem;
    }

    public void setOrderitem(OrderItem orderitem) {
        this.orderitem = orderitem;
    }

    public Map<Long, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Long, Integer> items) {
        this.items = items;
    }
}