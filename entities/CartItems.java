package com.amb.shop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class CartItems {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column private Long id;
    @Getter @Setter @Column private Integer quantity;

    @ManyToOne
    @Getter @Setter private Product product;
}
