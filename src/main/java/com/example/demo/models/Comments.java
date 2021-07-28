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
@Entity(name = "comments")
public class Comments {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "comment")
        private String comment;
        @Column(name = "taste_point")
        private Integer taste_point;
        @Column(name = "speed_point")
        private Integer speed_point;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "users_user_id", nullable = false)
        private Users users;

}
