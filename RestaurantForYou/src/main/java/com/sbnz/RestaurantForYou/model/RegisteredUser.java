package com.sbnz.RestaurantForYou.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class RegisteredUser extends User  {

	
	private static final long serialVersionUID = 1L;
	@OneToMany()
	private Set<Restaurant> recommendedRestaurants;
	
	public RegisteredUser() {
		recommendedRestaurants = new HashSet<Restaurant>();
	}

	public Set<Restaurant> getRecommendedRestaurants() {
		return recommendedRestaurants;
	}

	public void setRecommendedRestaurants(Set<Restaurant> recommendedRestaurants) {
		this.recommendedRestaurants = recommendedRestaurants;
	}
	
	


}
