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
@Entity(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "enabled")
    private String enabled;
    @Column(name = "name")
    private String name;
    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "users")
    private Set<Address> addresses = new HashSet<>();
    @OneToMany(mappedBy = "users")
    private Set<CardsInfo> cardsInfo = new HashSet<>();
    @OneToMany(mappedBy = "users")
    private Set<Comments> comments = new HashSet<>();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurants_restaurant_id", nullable = false)
    private Restaurants restaurants;
    @OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
    private Basket basket;


}
