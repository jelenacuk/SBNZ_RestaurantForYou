package com.sbnz.RestaurantForYou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbnz.RestaurantForYou.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
