package com.sbnz.RestaurantForYou.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ContactInfo {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String phone;
	@Column
	private String email;
	@Column
	private String website;
	
	public ContactInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public ContactInfo(String phone, String email, String website) {
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
