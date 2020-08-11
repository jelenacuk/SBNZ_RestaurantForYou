package com.sbnz.RestaurantForYou.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sbnz.RestaurantForYou.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	public Restaurant findOneByName(String name);
	
	@Query("SELECT r FROM Restaurant r WHERE  r.alarm != null")
	Page<Restaurant> findAlaramedRestaurants(Pageable pageable);
	
	
	@Query("SELECT r FROM Restaurant r WHERE  r.completed = true")
	Page<Restaurant> findCompletedRestaurants(Pageable pageable);
	
	@Query("SELECT r FROM Restaurant r WHERE  r.completed = true")
	List<Restaurant> findAllCompleted();
	
	@Query("SELECT r FROM Restaurant r WHERE  r.completed = false")
	List<Restaurant> findAllInompleted();
}
