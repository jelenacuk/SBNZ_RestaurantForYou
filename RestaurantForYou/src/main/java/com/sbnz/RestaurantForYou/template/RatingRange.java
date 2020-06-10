package com.sbnz.RestaurantForYou.template;

public class RatingRange {

	private double minRating;
	private double maxRating;
	
	public RatingRange() {
		// TODO Auto-generated constructor stub
	}

	public RatingRange(double minRating, double maxRating) {
		super();
		this.minRating = minRating;
		this.maxRating = maxRating;
	}

	public double getMinRating() {
		return minRating;
	}

	public void setMinRating(double minRating) {
		this.minRating = minRating;
	}

	public double getMaxRating() {
		return maxRating;
	}

	public void setMaxRating(double maxRating) {
		this.maxRating = maxRating;
	}
	
	
}
