package com.sbnz.RestaurantForYou.dto.api;

public class ItemDto {
	
	private String name;
	private String key;
	
	public ItemDto() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "CuisineDto [name=" + name + "]";
	}

}
