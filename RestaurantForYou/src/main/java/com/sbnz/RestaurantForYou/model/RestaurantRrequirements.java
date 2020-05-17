package com.sbnz.RestaurantForYou.model;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRrequirements {
	
	private List<Kitchen> kitchen = new ArrayList<Kitchen>();
	private List<Ambience> ambience = new ArrayList<Ambience>();
	private List<Music> music = new ArrayList<Music>();
	private List<Capacity> capacity = new ArrayList<Capacity>();
	private List<Price> price = new ArrayList<Price>();
	private boolean programForChildern;
	private boolean wideVariatyOfWine;
	private boolean garden;
	private boolean nearest;
	private boolean openNow;
	
	public RestaurantRrequirements() {
	}
	
	
	public List<Kitchen> getKitchen() {
		return kitchen;
	}
	public void setKitchen(List<Kitchen> kitchen) {
		this.kitchen = kitchen;
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
	public List<Price> getPrice() {
		return price;
	}
	public void setPrice(List<Price> price) {
		this.price = price;
	}
	public boolean isProgramForChildern() {
		return programForChildern;
	}
	public void setProgramForChildern(boolean programForChilern) {
		this.programForChildern = programForChilern;
	}
	public boolean isWideVariatyOfWine() {
		return wideVariatyOfWine;
	}
	public void setWideVariatyOfWine(boolean wideVariatyOfWine) {
		this.wideVariatyOfWine = wideVariatyOfWine;
	}
	public boolean isGarden() {
		return garden;
	}
	public void setGarden(boolean garden) {
		this.garden = garden;
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
				+ ", capacity=" + capacity + ", price=" + price + ", programForChildern=" + programForChildern
				+ ", wideVariatyOfWine=" + wideVariatyOfWine + ", garden=" + garden + ", nearest=" + nearest
				+ ", openNow=" + openNow + "]";
	}
	
	

}
