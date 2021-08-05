//package com.restaurantapi.models;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity(name = "menu")
//public class Menu {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(name = "enable")
//    private String enable;
//    @Column(name = "Meal")
//    private String Meal;
//
//    @OneToOne(mappedBy = "city", cascade = CascadeType.ALL)
//    private County county;
//    @OneToMany
//    private List<Meal> menulist;
//}
