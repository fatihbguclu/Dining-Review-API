package com.spring.api.controller;

import com.spring.api.domain.AdminReviewStatus;
import com.spring.api.domain.Review;
import com.spring.api.repositories.RestaurantRepository;
import com.spring.api.repositories.ReviewRepository;
import com.spring.api.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class ReviewController {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    public ReviewController(ReviewRepository reviewRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/reviews")
    public Iterable<Review> getAllReview(){
        return reviewRepository.findAll();
    }

    @GetMapping("/reviews/pending")
    public Iterable<Review> getPendingReviews(){
        return reviewRepository.findByReviewStatus(AdminReviewStatus.PENDING);
    }

    @GetMapping("/reviews/{id}")
    public Iterable<Review> getApprovedReviewByRestaurantId(@PathVariable String id){
        return reviewRepository.findByIdAndReviewStatus(Long.valueOf(id),AdminReviewStatus.APPROVED);
    }

    @PostMapping("/reviews")
    public Review createReview(@RequestBody Review review){
        if(restaurantRepository.findById(review.getRestaurantId()).isEmpty() &&
                userRepository.findByUsername(review.getSubmittedBy()).isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error");
        }
        return reviewRepository.save(review);
    }

    @PutMapping("/reviews/{id}/approve")
    public Review approveReview(@PathVariable String id){

        Optional<Review> optReview = reviewRepository.findById(Long.valueOf(id));
        if (optReview.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review Not Found By Id");
        }

        Review review = optReview.get();

        if (review.getReviewStatus().equals(AdminReviewStatus.APPROVED)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Review Already Approved");
        }else {
            review.setReviewStatus(AdminReviewStatus.APPROVED);
            return reviewRepository.save(review);
        }
    }
    @PutMapping("/reviews/{id}/reject")
    public Review rejectReview(@PathVariable String id){

        Optional<Review> optReview = reviewRepository.findById(Long.valueOf(id));
        if (optReview.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review Not Found By Id");
        }

        Review review = optReview.get();

        if (review.getReviewStatus().equals(AdminReviewStatus.REJECTED)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Review Already Rejected");
        }else {
            review.setReviewStatus(AdminReviewStatus.REJECTED);
            return reviewRepository.save(review);
        }
    }
}
