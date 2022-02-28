package com.spring.api.repositories;

import com.spring.api.domain.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant,Long> {

    boolean existsByPostcode(String postode);
    boolean existsByRestaurantName(String name);

    Optional<Restaurant> findByPostcode(String postcode);
}
