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
@Entity(name = "sube")
public class Sube {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "name")
        private String name;
        @Column(name = "status")
        private String status;
        @Column(name = "speed_rate")
        private Integer speed_rate;
        @Column(name = "taste_rate")
        private Integer taste_rate;
        @Column(name = "vote_count")
        private Integer vote_count;
        @Column(name = "comment_count")
        private Integer comment_count;

}
