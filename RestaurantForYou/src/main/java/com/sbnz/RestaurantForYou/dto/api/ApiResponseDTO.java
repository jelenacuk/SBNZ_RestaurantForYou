package com.sbnz.RestaurantForYou.dto.api;

import java.util.List;

public class ApiResponseDTO {
	
	private List<RestaurantDataDto> data;
	
	public ApiResponseDTO() {
		// TODO Auto-generated constructor stub
	}

	public List<RestaurantDataDto> getData() {
		return data;
	}

	public void setData(List<RestaurantDataDto> data) {
		this.data = data;
	}
	
	

}
