//package com.restaurantapi.models;
//
//import lombok.*;
//
//import javax.persistence.*;
//
//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity(name = "comments")
//public class Comments {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(name = "comment")
//    private String comment;
//    @Column(name = "taste_point")
//    private Integer taste_point;
//    @Column(name = "speed_point")
//    private Integer speed_point;
//
//    @ManyToOne
//    @JoinColumn(name = "branch_id", nullable = false)
//    private Branch branch;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "users_user_id", nullable = false)
//    private Users users;
//
//}
