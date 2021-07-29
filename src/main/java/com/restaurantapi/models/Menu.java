package com.restaurantapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "menu")
public class Menu {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "enable")
        private String enable;
        @Column(name = "Meal")
        private String Meal;

        @OneToOne(mappedBy = "city", cascade = CascadeType.ALL)
        private County county;
}
