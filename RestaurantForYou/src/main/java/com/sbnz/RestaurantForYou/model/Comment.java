package com.sbnz.RestaurantForYou.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private RegisteredUser user;

	@ManyToOne
	private Restaurant restaurant;
	
	@Column
	private String text;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment( RegisteredUser user, Restaurant restaurant, String text) {
		super();
		this.user = user;
		this.restaurant = restaurant;
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RegisteredUser getUser() {
		return user;
	}

	public void setUser(RegisteredUser user) {
		this.user = user;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
}
