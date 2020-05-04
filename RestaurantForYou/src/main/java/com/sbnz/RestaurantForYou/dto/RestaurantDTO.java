package com.sbnz.RestaurantForYou.dto;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDTO {

	private String name;
	private String price;
	private String capacity;
	private String kitchen;
	private String music;
	private String ambience;
	private boolean programForChildern;
	private boolean garden;
	private boolean wideRangeOfWines;
	private String street;
	private String number;
	private double latitude;
	private double longitude;
	private List<WorkingDayDTO> workingDays = new ArrayList<WorkingDayDTO>();

	public RestaurantDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getKitchen() {
		return kitchen;
	}

	public void setKitchen(String kitchen) {
		this.kitchen = kitchen;
	}

	public String getMusic() {
		return music;
	}

	public void setMusic(String music) {
		this.music = music;
	}

	public String getAmbience() {
		return ambience;
	}

	public void setAmbience(String ambience) {
		this.ambience = ambience;
	}

	public boolean isProgramForChildern() {
		return programForChildern;
	}

	public void setProgramForChildern(boolean programForChildern) {
		this.programForChildern = programForChildern;
	}

	public boolean isGarden() {
		return garden;
	}

	public void setGarden(boolean garden) {
		this.garden = garden;
	}

	public boolean isWideRangeOfWines() {
		return wideRangeOfWines;
	}

	public void setWideRangeOfWines(boolean wideRangeOfWines) {
		this.wideRangeOfWines = wideRangeOfWines;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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

	public List<WorkingDayDTO> getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(List<WorkingDayDTO> workingDays) {
		this.workingDays = workingDays;
	}

	

}