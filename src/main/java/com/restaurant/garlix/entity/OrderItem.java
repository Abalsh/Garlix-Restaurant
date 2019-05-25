package com.restaurant.garlix.entity;




import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Orders orders;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Item item;

    @NotNull
    private int quantity;

    public OrderItem() {
    }

    public OrderItem(Orders orders, Item item, @NotNull int quantity) {
        this.orders = orders;
        this.item = item;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
