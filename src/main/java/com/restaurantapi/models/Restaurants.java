//package com.restaurantapi.models;
//
//import com.restaurantapi.models.enumerated.Status;
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity(name = "restaurants")
//public class Restaurants {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(name = "name")
//    private String name;
//    @Column(name = "unit_type")
//    private String unit_type;
//    @Enumerated(EnumType.STRING)
//    @Column(name = "status")
//    private Status status;
//    @OneToMany(mappedBy = "restaurants")
//    private Set<Users> users = new HashSet<>();
//
//}
