package com.sbnz.RestaurantForYou.dto;

import java.util.ArrayList;
import java.util.List;


public class DissatisfiedUsersDTO {
	
	private RegistrationDTO user;
	private List<RestaurantDTO> restaurants;
	
	public DissatisfiedUsersDTO() {
		this.restaurants = new ArrayList<RestaurantDTO>();
	}

	public RegistrationDTO getUser() {
		return user;
	}

	public void setUser(RegistrationDTO user) {
		this.user = user;
	}

	public List<RestaurantDTO> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<RestaurantDTO> restaurants) {
		this.restaurants = restaurants;
	}
	

}
