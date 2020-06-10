package com.sbnz.RestaurantForYou.template;

public class NumberOfVotes {

	private long restaurantId;
	private int rating;
	
	public NumberOfVotes() {
		// TODO Auto-generated constructor stub
	}

	public NumberOfVotes(long restaurantId, int rating) {
		super();
		this.restaurantId = restaurantId;
		this.rating = rating;
	}

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
