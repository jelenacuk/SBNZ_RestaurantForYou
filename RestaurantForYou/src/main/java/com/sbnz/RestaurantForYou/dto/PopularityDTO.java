package com.sbnz.RestaurantForYou.dto;


public class PopularityDTO {

	private RestaurantDTO mostRecommended;
	private RestaurantDTO leastRecommended;
	
	public PopularityDTO() {
	}
	

	public PopularityDTO(RestaurantDTO mostRecommended, RestaurantDTO leastRecommended) {
		super();
		this.mostRecommended = mostRecommended;
		this.leastRecommended = leastRecommended;
	}


	public RestaurantDTO getMostRecommended() {
		return mostRecommended;
	}

	public void setMostRecommended(RestaurantDTO mostRecommended) {
		this.mostRecommended = mostRecommended;
	}

	public RestaurantDTO getLeastRecommended() {
		return leastRecommended;
	}

	public void setLeastRecommended(RestaurantDTO leastRecommended) {
		this.leastRecommended = leastRecommended;
	}
	
}
