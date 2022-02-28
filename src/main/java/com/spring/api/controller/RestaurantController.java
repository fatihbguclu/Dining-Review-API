package com.spring.api.controller;

import com.spring.api.domain.Restaurant;
import com.spring.api.repositories.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class RestaurantController {

    private final RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/restaurants")
    public Iterable<Restaurant> getAllRestaurant(){

        return restaurantRepository.findAll();

    }

    @GetMapping("/restaurants/search")
    public Restaurant getRestaurantByPostcode(@RequestParam String postcode){

        Optional<Restaurant> optRestaurant = restaurantRepository.findByPostcode(postcode);
        if (optRestaurant.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant Not Found");
        }

        return optRestaurant.get();
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant getRestaurantById(@PathVariable String id){
        Optional<Restaurant> optRestaurant = restaurantRepository.findById(Long.valueOf(id));
        if (optRestaurant.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant Not Found");
        }

        return optRestaurant.get();
    }

    @PostMapping("/restaurants")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant){

        if (restaurantRepository.existsByPostcode(restaurant.getPostcode()) &&
                restaurantRepository.existsByRestaurantName(restaurant.getRestaurantName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Restaurant Already Exist");
        }

        return restaurantRepository.save(restaurant);
    }

}
