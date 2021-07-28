package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "basket")
public class Basket extends BaseDTO{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "Meal")
        private String Meal;
        @Column(name = "count")
        private Integer count;
        @Column(name = "totalPrice")
        private Float totalPrice;

        @OneToOne
        @MapsId
        private Users users;
        @OneToMany(mappedBy = "basket")
        private Set<Order> order = new HashSet<>();
        @ManyToMany(mappedBy = "basket")
        private Set<com.example.demo.models.Meal> meal = new HashSet<>();



}
