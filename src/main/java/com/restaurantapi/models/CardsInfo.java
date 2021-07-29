package com.restaurantapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Month;
import java.time.Year;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cards_info")
public class CardsInfo {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "card_no")
        private Integer card_no;
        @Column(name = "name")
        private String name;
        @Column(name = "exp_year")
        private Year exp_year;
        @Column(name = "exp_month")
        private Month exp_month;
        @Column(name = "ccv")
        private Integer ccv;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "users_user_id", nullable = false)
        private Users users;

}

