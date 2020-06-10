package com.sbnz.RestaurantForYou.dto;

public class ReviewDTO {

	private Long restaurantId;
	private int rating;
	
	public ReviewDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long id) {
		this.restaurantId = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
