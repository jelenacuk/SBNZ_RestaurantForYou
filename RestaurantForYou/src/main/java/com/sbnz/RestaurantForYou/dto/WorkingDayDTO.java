package com.sbnz.RestaurantForYou.dto;

public class WorkingDayDTO {

	private String day;
	private boolean open;
	private String openingTime;
	private String closingTime;
	
	public WorkingDayDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}

	public String getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(String closingTime) {
		this.closingTime = closingTime;
	}
	
	
}
