package com.amb.shop.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@NoArgsConstructor @ToString @EqualsAndHashCode
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;

    @Getter @Setter @Column private String name;
    //@Getter @Setter @Column private Integer stock;
    @Getter @Setter @Column private Long price;
}