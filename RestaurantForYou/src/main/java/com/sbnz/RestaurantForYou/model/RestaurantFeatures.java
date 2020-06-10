package com.sbnz.RestaurantForYou.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RestaurantFeatures {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private boolean liveMusic;
	@Column
	private boolean alcohol;
	@Column
	private boolean reservations;
	@Column
	private boolean programForChildern;
	@Column
	private boolean wifi;
	@Column
	private boolean tv;
	@Column
	private boolean outdoorSeating;
	@Column
	private boolean parking;
	
	public RestaurantFeatures() {
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

	public boolean isProgramForChildern() {
		return programForChildern;
	}

	public void setProgramForChildern(boolean programForChildern) {
		this.programForChildern = programForChildern;
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
