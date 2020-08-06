package com.sbnz.RestaurantForYou.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class RestaurantDTO {

	private Long id;
	private String name;
	private String description;
	private String photo;
	private String price;
	private List<String> cuisine;
	private LocationDTO location;
	private ContactInfoDTO contact;
	private RestaurantFeaturesDTO features;
	private Boolean closed;
	private String openNowText;
	List<String> dietaryRestrictions = new ArrayList<String>();
	
	private double averageGrade;
	private ReportDTO reportDTO;
	private LocalDate alarmCreation;
	private long size;

	public RestaurantDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public ReportDTO getReportDTO() {
		return reportDTO;
	}

	public void setReportDTO(ReportDTO reportDTO) {
		this.reportDTO = reportDTO;
	}

	public RestaurantFeaturesDTO getFeatures() {
		return features;
	}

	public void setFeatures(RestaurantFeaturesDTO features) {
		this.features = features;
	}

	public double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}

	public LocalDate getAlarmCreation() {
		return alarmCreation;
	}

	public void setAlarmCreation(LocalDate alarmCreation) {
		this.alarmCreation = alarmCreation;
	}

	public LocationDTO getLocation() {
		return location;
	}

	public void setLocation(LocationDTO location) {
		this.location = location;
	}

	public ContactInfoDTO getContact() {
		return contact;
	}

	public void setContact(ContactInfoDTO contact) {
		this.contact = contact;
	}


	public List<String> getCuisine() {
		return cuisine;
	}

	public void setCuisine(List<String> cuisine) {
		this.cuisine = cuisine;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Boolean getClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
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

}
