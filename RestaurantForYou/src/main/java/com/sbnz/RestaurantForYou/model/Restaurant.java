package com.sbnz.RestaurantForYou.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Restaurant {

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String name;
	@Enumerated(EnumType.STRING)
	private Price price;
	@Enumerated(EnumType.STRING)
	private Capacity capacity;
	@Enumerated(EnumType.STRING)
	private Kitchen kitchen;
	@Enumerated(EnumType.STRING)
	private Music music;
	@Enumerated(EnumType.STRING)
	private Ambience ambience;
	@Column
	private boolean programForChildern;
	@Column
	private boolean garden;
	@Column
	private boolean wideRangeOfWines;
	@OneToOne(cascade = CascadeType.ALL)
	private Location location;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "time_mapping", 
      joinColumns = {@JoinColumn (name = "restaurant_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn (name = "workingday_id", referencedColumnName = "id")})
    @MapKey(name = "day")
	private Map<String, WorkingDay> workingDays = new HashMap<String, WorkingDay>();

	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Capacity getCapacity() {
		return capacity;
	}

	public void setCapacity(Capacity capacity) {
		this.capacity = capacity;
	}

	public Kitchen getKitchen() {
		return kitchen;
	}

	public void setKitchen(Kitchen kitchen) {
		this.kitchen = kitchen;
	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	public Ambience getAmbience() {
		return ambience;
	}

	public void setAmbience(Ambience ambience) {
		this.ambience = ambience;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, WorkingDay> getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(Map<String, WorkingDay> workingDays) {
		this.workingDays = workingDays;
	}

}
