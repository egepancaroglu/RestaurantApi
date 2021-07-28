package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "order")
public class Order {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "amount")
        private Integer amount;
        @Column(name = "tarih")
        private Date tarih;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "basket_basket_id", nullable = false)
        private Basket basket;

}
