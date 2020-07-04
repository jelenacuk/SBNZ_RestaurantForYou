package com.sbnz.RestaurantForYou.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StatisticsDTO {

	private RestaurantDTO mostRecommended;
	private RestaurantDTO leastRecommended;
	private Set<DissatisfiedUsersDTO> dissatisfiedUsers;
	
	public StatisticsDTO() {
		this.dissatisfiedUsers = new HashSet<DissatisfiedUsersDTO>();
	}
	

	public StatisticsDTO(RestaurantDTO mostRecommended, RestaurantDTO leastRecommended,
			Set<DissatisfiedUsersDTO> dissatisfiedUsers) {
		super();
		this.mostRecommended = mostRecommended;
		this.leastRecommended = leastRecommended;
		this.dissatisfiedUsers = dissatisfiedUsers;
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

	public Set<DissatisfiedUsersDTO> getDissatisfiedUsers() {
		return dissatisfiedUsers;
	}

	public void setDissatisfiedUsers(Set<DissatisfiedUsersDTO> dissatisfiedUsers) {
		this.dissatisfiedUsers = dissatisfiedUsers;
	}
	
	
}
