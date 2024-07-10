package com.amb.shop.entities;

import jakarta.persistence.*;
import lombok.*;

//Definimos cliente como una entidad, colocamos un contructor vacio, el metodo toString
@Entity
@NoArgsConstructor @ToString @EqualsAndHashCode @Getter @Setter
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;

    @Getter @Setter @Column private String name;
    @Getter @Setter @Column private String lastname;
    @Getter @Setter @Column private Integer age;
    @Getter @Setter @Column private Integer dni;
}