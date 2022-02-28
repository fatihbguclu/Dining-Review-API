package com.spring.api.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "REVIEW")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "SUBMITTED_BY")
    private String submittedBy;

    @Column(name = "COMMENTARY")
    private String commentary;

    @Column(name = "SCORE")
    private int score;

    @Column(name = "RESTAURANT_ID")
    private Long restaurantId;

    @Column(name = "REVIEW_STATUS")
    @Enumerated(EnumType.STRING)
    private AdminReviewStatus reviewStatus;

}
