//package com.restaurantapi.models;
//
//import com.restaurantapi.models.enumerated.Role;
//import com.restaurantapi.models.enumerated.Status;
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
//@Entity(name = "branch")
//public class Branch {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(name = "name")
//    private String name;
//    @Enumerated(EnumType.STRING)
//    @Column(name = "status")
//    private Status status;
//    @Enumerated(EnumType.STRING)
//    @Column(name = "roles")
//    private Role role;
//    @Column(name = "speed_rate")
//    private Integer speed_rate;
//    @Column(name = "taste_rate")
//    private Integer taste_rate;
//    @Column(name = "vote_count")
//    private Integer vote_count;
//    @Column(name = "comment_count")
//    private Integer comment_count;
//
//    @OneToOne
//    private Menu menu;
//    @OneToMany
//    private List<Comments> comments;
//    @ManyToOne
//    @JoinColumn(name = "restaurants_restaurant_id")
//    private Restaurants restaurants;
//
//}
