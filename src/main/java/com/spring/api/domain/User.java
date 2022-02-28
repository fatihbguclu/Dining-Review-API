package com.spring.api.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ZIP_CODE")
    private String zipcode;

    @Column(name = "PEANUT_ALLERGY")
    private Boolean isPeanutAllergies;

    @Column(name = "EGG_ALLERGY")
    private Boolean isEggAllergies;

    @Column(name = "DAIRY_ALLERGY")
    private Boolean isDairyAllergies;

}
