package com.restaurantapi.models;

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
@Entity(name = "meal")
public class Meal {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "name")
        private String name;
        @Column(name = "price")
        private Float price;
        @Column(name = "Item")
        private String Item;

        @OneToOne
        @MapsId
        private Menu menu;
        @ManyToMany
        @JoinTable(
                name = "items_has_meal",
                joinColumns = @JoinColumn(name = "meal_meal_id"),
                inverseJoinColumns = @JoinColumn(name = "items_item_id")
        )
        private Set<Items> items = new HashSet<>();
        @ManyToMany
        @JoinTable(
                name = "meal_has_basket",
                joinColumns = @JoinColumn(name = "meal_meal_id"),
                inverseJoinColumns = @JoinColumn(name = "basket_basket_id")
        )
        private Set<Basket> basket = new HashSet<>();
}
