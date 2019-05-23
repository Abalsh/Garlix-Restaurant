package com.restaurant.garlix.entity;




import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class OrderItem {

    @Id
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Orders orders;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Item item;

    @NotNull
    private int quantity;


}
