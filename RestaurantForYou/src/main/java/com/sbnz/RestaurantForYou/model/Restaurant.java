package com.sbnz.RestaurantForYou.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Restaurant {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String name; 
	@Column(length = 2000)
	private String description;
	@Column
	private String photo;
	@OneToOne(cascade=CascadeType.ALL)
	private Location location;
	@OneToOne(cascade=CascadeType.ALL)
	private ContactInfo contact;
	@Column
	private Boolean closed;
	@Column
	private String openNowText;
	@Column
	private String price;
	@ElementCollection
	List<String> cuisine;
	@ElementCollection
	List<String> dietaryRestrictions = new ArrayList<String>();
	@OneToOne
	private RestaurantFeatures features;
	@Column
	private Integer score;
	@Column
	private Double average;
	@OneToMany()
	private Set<Review> restaurantReviews = new HashSet<Review>();
	@OneToMany()
	private Set<Comment> restaurantComments = new HashSet<Comment>();
	@Column
	private LocalDate alarm;
	@Column
	private Boolean completed;
	
	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RestaurantFeatures getFeatures() {
		return features;
	}

	public void setFeatures(RestaurantFeatures features) {
		this.features = features;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}

	public Set<Review> getRestaurantReviews() {
		return restaurantReviews;
	}

	public void setRestaurantReviews(Set<Review> restaurantReviews) {
		this.restaurantReviews = restaurantReviews;
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

	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	

	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}



	public boolean isComplete() {
		return completed;
	}

	public void setComplete(boolean complete) {
		this.completed = complete;
	}

	public List<String> getCuisine() {
		return cuisine;
	}

	public void setCuisine(List<String> cuisine) {
		this.cuisine = cuisine;
	}

	public String getOpenNowText() {
		return openNowText;
	}

	public void setOpenNowText(String openNowText) {
		this.openNowText = openNowText;
	}

	public List<String> getDietaryRestrictions() {
		return dietaryRestrictions;
	}

	public void setDietaryRestrictions(List<String> dietaryRestrictions) {
		this.dietaryRestrictions = dietaryRestrictions;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public ContactInfo getContact() {
		return contact;
	}

	public void setContact(ContactInfo contact) {
		this.contact = contact;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Boolean getClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	public LocalDate getAlarm() {
		return alarm;
	}

	public void setAlarm(LocalDate alarm) {
		this.alarm = alarm;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Set<Comment> getRestaurantComments() {
		return restaurantComments;
	}

	public void setRestaurantComments(Set<Comment> restaurantComments) {
		this.restaurantComments = restaurantComments;
	}
}
