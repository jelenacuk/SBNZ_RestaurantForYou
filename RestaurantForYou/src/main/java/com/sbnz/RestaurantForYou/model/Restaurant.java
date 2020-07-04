package com.sbnz.RestaurantForYou.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class Restaurant {

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String description;
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
	private String image;
	@OneToOne
	private RestaurantFeatures features;
	@OneToOne(cascade = CascadeType.ALL)
	private Location location;
	@Column
	private int score;
	@OneToMany()
	private Set<Review> restaurantReviews = new HashSet<Review>();
	@JsonInclude()
	@Transient
	private Double average;
	

	public Restaurant() {
		this.score = 0;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int rating) {
		this.score = rating;
	}

	public Set<Review> getResetaurantReviews() {
		return restaurantReviews;
	}

	public void setRestaurantReviews(Set<Review> resetaurantReviews) {
		this.restaurantReviews = resetaurantReviews;
	}

	public RestaurantFeatures getFeatures() {
		return features;
	}

	public void setFeatures(RestaurantFeatures features) {
		this.features = features;
	}

	public Set<Review> getRestaurantReviews() {
		return restaurantReviews;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}
	
	public int calculateMatching(RestaurantRrequirements requerments) {
		int matching = 0;
		System.out.println(name.toUpperCase());
		if (requerments.getPrice().contains(price)) {
			System.out.println("\tMatch => PRICE");
			matching +=2;
		}
		if (requerments.getCapacity().contains(capacity)) {
			System.out.println("\tMatch => CAPACITY");
			matching +=1;
		}
		if (requerments.getKitchen().contains(kitchen)) {
			System.out.println("\tMatch => KITCHEN");
			matching +=2;
		}
		if (requerments.getMusic().contains(music)) {
			System.out.println("\tMatch => MUSIC");
			matching +=1;
		}
		if (requerments.getAmbience().contains(ambience)) {
			System.out.println("\tMatch => AMBIENCE");
			matching +=1;
		}
		if (requerments.getFeatures().isAlcohol() && features.isAlcohol()) {
			System.out.println("\tMatch => ALCOHOL");
			matching +=1;
		}
		if (requerments.getFeatures().isLiveMusic() && features.isLiveMusic()) {
			System.out.println("\tMatch => LIVE MUSIC");
			matching +=1;
		}
		if (requerments.getFeatures().isOutdoorSeating() && features.isOutdoorSeating()) {
			System.out.println("\tMatch => BASTA");
			matching +=1;
		}
		if (requerments.getFeatures().isParking() && features.isParking()) {
			System.out.println("\tMatch => PARKING");
			matching +=1;
		}
		if (requerments.getFeatures().isProgramForChildern() && features.isProgramForChildern()) {
			System.out.println("\tMatch => CHILDERN");
			matching +=1;
		}
		if (requerments.getFeatures().isReservations() && features.isReservations()) {
			System.out.println("\tMatch => RESERVATION");
			matching +=1;
		}
		if (requerments.getFeatures().isTv() && features.isTv()) {
			System.out.println("\tMatch => TV");
			matching +=1;
		}
		if (requerments.getFeatures().isWifi() && features.isWifi()) {
			System.out.println("\tMatch => WIFI");
			matching +=1;
		}
		score = matching;
		System.out.println("matching = " + matching);
		return matching;
	}

}
