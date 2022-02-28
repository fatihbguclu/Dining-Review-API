package com.spring.api.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "RESTAURANT")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "RESTAURANT_NAME")
    private String restaurantName;

    @Column(name = "POST_CODE")
    private String postcode;

    @Column(name = "REVIEW_SCORE")
    private Float reviewScore;

}
