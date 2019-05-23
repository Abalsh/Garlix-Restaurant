package com.restaurant.garlix.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    public long getId() {
        return id;
    }

    public String getClient_name() {
        return Client_name;
    }

    public String getClient_address() {
        return Client_address;
    }

    public float getTotal_price() {
        return Total_price;
    }

    public boolean isTakeaway() {
        return takeaway;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setClient_name(String client_name) {
        Client_name = client_name;
    }

    public void setClient_address(String client_address) {
        Client_address = client_address;
    }

    public void setTotal_price(float total_price) {
        Total_price = total_price;
    }

    public void setTakeaway(boolean takeaway) {
        this.takeaway = takeaway;
    }
}