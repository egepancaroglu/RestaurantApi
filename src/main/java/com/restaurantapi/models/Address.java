package com.restaurantapi.models;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "addresses")
public class Address extends BaseDTO {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "district")
        private String district;
        @Column(name = "other_content")
        private String other_content;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "county_county_id", referencedColumnName = "county_id")
        private County county;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "users_user_id", referencedColumnName = "user_id")
        private Users users;


}
