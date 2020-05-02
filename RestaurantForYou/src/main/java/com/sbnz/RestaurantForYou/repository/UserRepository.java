package com.sbnz.RestaurantForYou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbnz.RestaurantForYou.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findOneByUsername(String username);
}
