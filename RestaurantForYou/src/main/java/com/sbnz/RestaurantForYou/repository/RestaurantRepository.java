package com.sbnz.RestaurantForYou.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sbnz.RestaurantForYou.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	@Query("SELECT r FROM Restaurant r WHERE  r.alarm != null")
	Page<Restaurant> findAlaramedRestaurants(Pageable pageable);
	
}
