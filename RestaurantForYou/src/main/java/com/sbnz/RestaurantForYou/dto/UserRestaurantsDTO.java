package com.sbnz.RestaurantForYou.dto;

import java.util.ArrayList;
import java.util.List;

import com.sbnz.RestaurantForYou.model.RegisteredUser;
import com.sbnz.RestaurantForYou.model.Restaurant;

public class UserRestaurantsDTO {
	
	private RegisteredUser user;
	private List<Restaurant> restaurants;
	
	public UserRestaurantsDTO() {
		this.restaurants = new ArrayList<Restaurant>();
	}

	public UserRestaurantsDTO(RegisteredUser user, List<Restaurant> restaurants) {
		this.user = user;
		this.restaurants = restaurants;
	}

	public RegisteredUser getUser() {
		return user;
	}

	public void setUser(RegisteredUser user) {
		this.user = user;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	
	

}
