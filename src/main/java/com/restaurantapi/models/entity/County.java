package com.restaurantapi.models.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "county")
public class County extends BaseDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "county")
    private Address address;
    @ManyToOne
    @JoinColumn(name = "city_idcity", nullable = false)
    private City city;


}
