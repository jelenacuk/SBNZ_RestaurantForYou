package com.sbnz.RestaurantForYou.dto;


public class RestaurantFeaturesDTO {

	private boolean liveMusic;
	private boolean alcohol;
	private boolean reservations;
	private boolean programForChiledern;
	private boolean wifi;
	private boolean tv;
	private boolean outdoorSeating;
	private boolean parking;
	
	public RestaurantFeaturesDTO() {
		// TODO Auto-generated constructor stub
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
	
	
}
