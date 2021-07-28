package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "addresses")
public class Address extends BaseDTO{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "district")
        private String district;
        @Column(name = "other_content")
        private String other_content;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "county_county_id", nullable = false)
        private County county;
        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "users_user_id", nullable = false)
        private Users users;





}
