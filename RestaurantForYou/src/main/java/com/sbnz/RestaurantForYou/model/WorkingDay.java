package com.sbnz.RestaurantForYou.model;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WorkingDay {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String day;
	@Column
	private boolean open;
	@Column
	private LocalTime openingTime;
	@Column
	private LocalTime closingTime;
	
	public WorkingDay() {
		// TODO Auto-generated constructor stub
	}

	public WorkingDay(String day, boolean open, LocalTime openingTime, LocalTime closingTime) {
		super();
		this.day = day;
		this.open = open;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public LocalTime getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(LocalTime openingTime) {
		this.openingTime = openingTime;
	}

	public LocalTime getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(LocalTime closingTime) {
		this.closingTime = closingTime;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	
	
}
