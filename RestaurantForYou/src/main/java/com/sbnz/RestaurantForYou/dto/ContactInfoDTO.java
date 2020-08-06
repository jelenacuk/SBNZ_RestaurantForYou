package com.sbnz.RestaurantForYou.dto;

public class ContactInfoDTO {

	
	private String phone;
	private String email;
	private String website;
	
	public ContactInfoDTO() {
		// TODO Auto-generated constructor stub
	}

	public ContactInfoDTO(String phone, String email, String website) {
		super();
		this.phone = phone;
		this.email = email;
		this.website = website;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	
}
