package com.amb.shop.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

//Definimos la entidad
@Entity
@NoArgsConstructor @ToString @EqualsAndHashCode
public class Invoice {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;

    @Getter @Setter private double total;

    @OneToOne
    @Getter @Setter private Client client;

    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date purchasedate;
}
