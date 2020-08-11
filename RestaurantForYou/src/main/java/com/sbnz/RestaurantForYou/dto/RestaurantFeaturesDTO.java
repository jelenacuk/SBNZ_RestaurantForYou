package com.sbnz.RestaurantForYou.dto;

import java.util.List;

public class RestaurantFeaturesDTO {

	private boolean liveMusic;
	private boolean alcohol;
	private boolean reservations;
	private boolean programForChiledern;
	private boolean wifi;
	private boolean tv;
	private boolean outdoorSeating;
	private boolean parking;
	private String capacity;
	private String price;
	private List<String> ambience;
	private List<String> music;
	
	public RestaurantFeaturesDTO() {
	}

	public boolean isLiveMusic() {
		return liveMusic;
	}

	public void setLiveMusic(boolean liveMusic) {
		this.liveMusic = liveMusic;
	}

	public boolean isAlcohol() {
		return alcohol;
	}

	public void setAlcohol(boolean alcohol) {
		this.alcohol = alcohol;
	}

	public boolean isReservations() {
		return reservations;
	}

	public void setReservations(boolean reservations) {
		this.reservations = reservations;
	}

	public boolean isProgramForChiledern() {
		return programForChiledern;
	}

	public void setProgramForChiledern(boolean programForChiledern) {
		this.programForChiledern = programForChiledern;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public boolean isTv() {
		return tv;
	}

	public void setTv(boolean tv) {
		this.tv = tv;
	}

	public boolean isOutdoorSeating() {
		return outdoorSeating;
	}

	public void setOutdoorSeating(boolean outdoorSeating) {
		this.outdoorSeating = outdoorSeating;
	}

	public boolean isParking() {
		return parking;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public List<String> getAmbience() {
		return ambience;
	}

	public void setAmbience(List<String> ambience) {
		this.ambience = ambience;
	}

	public List<String> getMusic() {
		return music;
	}

	public void setMusic(List<String> music) {
		this.music = music;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
