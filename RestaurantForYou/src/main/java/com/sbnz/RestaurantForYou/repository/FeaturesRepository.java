package com.sbnz.RestaurantForYou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbnz.RestaurantForYou.model.RestaurantFeatures;
@Repository
public interface FeaturesRepository  extends JpaRepository<RestaurantFeatures, Long>{

}
