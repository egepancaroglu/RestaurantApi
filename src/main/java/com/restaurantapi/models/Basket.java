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
@Entity(name = "basket")
public class Basket extends BaseDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private Set<Meal> meal = new HashSet<>();


}
