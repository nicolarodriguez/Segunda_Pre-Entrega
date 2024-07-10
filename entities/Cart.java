package com.amb.shop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column private Long id;

    @OneToOne
    @Getter @Setter private Client client;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter @Setter
    @Column
    private List<CartItems> cartItems = new ArrayList<>();
}
