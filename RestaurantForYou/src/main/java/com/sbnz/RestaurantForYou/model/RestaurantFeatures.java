package com.sbnz.RestaurantForYou.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@Enumerated(EnumType.STRING)
	private Capacity capacity;
	@Enumerated(EnumType.STRING)
	private Price price;
	@Column
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = Music.class)
	private List<Music> music;
	@Column
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = Ambience.class)
	private List<Ambience> ambience;
	
	public RestaurantFeatures() {
		this.music = new ArrayList<Music>();
		this.ambience = new ArrayList<Ambience>();
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Capacity getCapacity() {
		return capacity;
	}

	public void setCapacity(Capacity capacity) {
		this.capacity = capacity;
	}

	public List<Music> getMusic() {
		return music;
	}

	public void setMusic(List<Music> music) {
		this.music = music;
	}

	public List<Ambience> getAmbience() {
		return ambience;
	}

	public void setAmbience(List<Ambience> ambience) {
		this.ambience = ambience;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	
	
	
	
	
}
