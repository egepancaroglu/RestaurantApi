//package com.restaurantapi.models;
//
//import lombok.*;
//
//import javax.persistence.*;
//
//@Builder
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity(name = "addresses")
//public class Address extends BaseDTO {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(name = "district")
//    private String district;
//    @Column(name = "other_content")
//    private String other_content;
//
//    @OneToOne
//    @JoinColumn(name = "county_county_id", nullable = false)
//    private County county;
//    @OneToOne
//    @JoinColumn(name = "county_city_idcity", nullable = false)
//    private City city;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "users_user_id", referencedColumnName = "user_id")
//    private Users users;
//    @OneToOne
//    @JoinColumn(name = "branch_branch_id")
//    private Branch branch;
//
//
//}
