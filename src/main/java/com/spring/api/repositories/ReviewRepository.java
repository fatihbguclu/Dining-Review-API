package com.spring.api.repositories;

import com.spring.api.domain.AdminReviewStatus;
import com.spring.api.domain.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review,Long> {

    Iterable<Review> findByIdAndReviewStatus(Long id, AdminReviewStatus status);
    Iterable<Review> findByReviewStatus(AdminReviewStatus status);
}
