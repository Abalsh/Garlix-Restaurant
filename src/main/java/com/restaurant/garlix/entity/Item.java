package com.restaurant.garlix.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "item_id")
    private long id;
    @NotNull
    @Column(unique = true, name = "item_name")
    private String name;
    @NotNull
    @Column(name = "item_description")
    private String description;
    @Column(name = "item_price")
    private float price;
    @Column(name = "item_status")
    private boolean active;

    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderitems;

    public Item() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
