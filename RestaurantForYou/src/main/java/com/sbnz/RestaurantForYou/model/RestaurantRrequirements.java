package com.sbnz.RestaurantForYou.model;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRrequirements {
	
	private List<String> kitchen = new ArrayList<String>();
	private List<Ambience> ambience = new ArrayList<Ambience>();
	private List<Music> music = new ArrayList<Music>();
	private List<Capacity> capacity = new ArrayList<Capacity>();
	private List<Price> price = new ArrayList<Price>();
	private RestaurantFeatures features;
	private boolean nearest = false;
	private boolean openNow = false;
	private boolean processed = false;
	
	public RestaurantRrequirements() {
		features = new RestaurantFeatures();
		features.setAlcohol(false);
		features.setLiveMusic(false);
		features.setOutdoorSeating(false);
		features.setParking(false);
		features.setProgramForChildern(false);
		features.setTv(false);
		features.setWifi(false);
		features.setReservations(false);
	}
	
	
	public List<Ambience> getAmbience() {
		return ambience;
	}
	public void setAmbience(List<Ambience> ambience) {
		this.ambience = ambience;
	}
	public List<Music> getMusic() {
		return music;
	}
	public void setMusic(List<Music> music) {
		this.music = music;
	}
	public List<Capacity> getCapacity() {
		return capacity;
	}
	public void setCapacity(List<Capacity> capacity) {
		this.capacity = capacity;
	}
	
	public boolean isNearest() {
		return nearest;
	}
	public void setNearest(boolean nearest) {
		this.nearest = nearest;
	}
	public boolean isOpenNow() {
		return openNow;
	}
	public void setOpenNow(boolean openNow) {
		this.openNow = openNow;
	}


	@Override
	public String toString() {
		return "RestaurantRrequirements [kitchen=" + kitchen + ", ambience=" + ambience + ", music=" + music
				+ ", capacity=" + capacity + ", price=" + price + ", programForChildern=" + features.isProgramForChildern()
				+ ", alcohol=" + features.isAlcohol() + ", garden=" + features.isOutdoorSeating() 
				 + ", wifi=" + features.isWifi()  + ", tv=" + features.isTv()  + ", reservations=" + features.isReservations()
				 + ", parking=" + features.isParking() + ", liveMusic=" + features.isLiveMusic()
				 + ", nearest=" + nearest
				+ ", openNow=" + openNow + "]";
	}


	public RestaurantFeatures getFeatures() {
		return features;
	}


	public void setFeatures(RestaurantFeatures features) {
		this.features = features;
	}


	public boolean isProcessed() {
		return processed;
	}


	public void setProcessed(boolean processed) {
		this.processed = processed;
	}


	public List<String> getKitchen() {
		return kitchen;
	}


	public void setKitchen(List<String> kitchen) {
		this.kitchen = kitchen;
	}


	public List<Price> getPrice() {
		return price;
	}


	public void setPrice(List<Price> price) {
		this.price = price;
	}

	
	

}
