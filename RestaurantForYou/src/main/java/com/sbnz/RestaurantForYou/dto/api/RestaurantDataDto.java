package com.sbnz.RestaurantForYou.dto.api;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDataDto {
	
	private String name; 
	private String description;
	private String phone;
	private String email;
	private String website;
	private ImagesWrapperDTO photo;
	private double latitude;
	private double longitude;
	private String address;
	private int num_reviews;
	private double rating;
	private boolean is_closed;
	private String open_now_text;
	private String price;
	private List<ItemDto> cuisine = new ArrayList<ItemDto>();
	private List<ItemDto> dietary_restrictions = new ArrayList<ItemDto>();
	
	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getWebsite() {
		return website;
	}


	public void setWebsite(String website) {
		this.website = website;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
	public RestaurantDataDto() {
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public ImagesWrapperDTO getPhoto() {
		return photo;
	}


	public void setPhoto(ImagesWrapperDTO photo) {
		this.photo = photo;
	}


	public int getNum_reviews() {
		return num_reviews;
	}


	public void setNum_reviews(int num_reviews) {
		this.num_reviews = num_reviews;
	}


	public boolean isIs_closed() {
		return is_closed;
	}


	public void setIs_closed(boolean is_closed) {
		this.is_closed = is_closed;
	}


	public String getOpen_now_text() {
		return open_now_text;
	}


	public void setOpen_now_text(String open_now_text) {
		this.open_now_text = open_now_text;
	}


	public List<ItemDto> getCuisine() {
		return cuisine;
	}


	public void setCuisine(List<ItemDto> cuisine) {
		this.cuisine = cuisine;
	}


	public List<ItemDto> getDietary_restrictions() {
		return dietary_restrictions;
	}


	public void setDietary_restrictions(List<ItemDto> dietary_restrictions) {
		this.dietary_restrictions = dietary_restrictions;
	}


	@Override
	public String toString() {
		return "RestaurantDataDto [name=" + name + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}






	
	
	

}
