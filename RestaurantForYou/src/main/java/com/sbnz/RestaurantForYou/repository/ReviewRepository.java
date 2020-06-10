package com.sbnz.RestaurantForYou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbnz.RestaurantForYou.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
