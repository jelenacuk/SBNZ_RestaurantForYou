package com.sbnz.RestaurantForYou.converter;

import java.util.ArrayList;
import java.util.List;

import com.sbnz.RestaurantForYou.dto.RestaurantFeaturesDTO;
import com.sbnz.RestaurantForYou.dto.api.ItemDto;
import com.sbnz.RestaurantForYou.dto.api.RestaurantDataDto;
import com.sbnz.RestaurantForYou.model.Ambience;
import com.sbnz.RestaurantForYou.model.Capacity;
import com.sbnz.RestaurantForYou.model.ContactInfo;
import com.sbnz.RestaurantForYou.model.Location;
import com.sbnz.RestaurantForYou.model.Music;
import com.sbnz.RestaurantForYou.model.Price;
import com.sbnz.RestaurantForYou.model.Restaurant;
import com.sbnz.RestaurantForYou.model.RestaurantFeatures;

public class RestaurantSetter {
	
	public static Restaurant restaurantSettter(Restaurant api, RestaurantDataDto dto) {
		
		api.setName(dto.getName());
		if (dto.getDescription() == null) {
			api.setDescription("");
		}
		else {
			api.setDescription(dto.getDescription());
		}
		if (dto.isIs_closed()) {
			api.setClosed(dto.isIs_closed());
		}else {
			api.setClosed(false);
		}
		
		api.setOpenNowText(dto.getOpen_now_text());
		if (dto.getPhoto() != null) {
			api.setPhoto(dto.getPhoto().getImages().getOriginal().getUrl());
		}
		api.setPrice(dto.getPrice());
		List<String> cuisine = new ArrayList<String>();
		for (ItemDto item : dto.getCuisine()) {
			cuisine.add(item.getName());
		}
		api.setCuisine(cuisine);
		
		List<String> dietaryRestrictions = new ArrayList<String>();
		for (ItemDto item : dto.getDietary_restrictions()) {
			dietaryRestrictions.add(item.getName());
		}
		api.setDietaryRestrictions(dietaryRestrictions);
		if (api.getLocation() != null) {
			api.getLocation().setAddress(dto.getAddress());
			api.getLocation().setLatitude(dto.getLatitude());
			api.getLocation().setLongitude(dto.getLongitude());
			}
		else {
			api.setLocation(RestaurantSetter.createLocationInfo(dto));
		}
		if (api.getContact() != null) {
			api.getContact().setEmail(dto.getEmail());
			api.getContact().setWebsite(dto.getWebsite());
			api.getContact().setPhone(dto.getPhone());
		}
		else {
			api.setContact(RestaurantSetter.createContactInfo(dto));
		}
		return api;

	}
	
	private static Location createLocationInfo(RestaurantDataDto dto) {
		Location location = new Location(dto.getLatitude(), dto.getLongitude(), dto.getAddress());
		return location;
	}
	
	private static ContactInfo createContactInfo(RestaurantDataDto dto) {
		ContactInfo contact = new ContactInfo(dto.getPhone(), dto.getEmail(), dto.getWebsite());
		return contact;
	}
	
	public static RestaurantFeatures createFeatures(RestaurantFeaturesDTO dto) {
		RestaurantFeatures features = new RestaurantFeatures();
		for (String music: dto.getMusic()) {
			features.getMusic().add(Music.StringToEnum(music));
		}
		for (String ambience: dto.getAmbience()) {
			features.getAmbience().add(Ambience.StringToEnum(ambience));
		}
		features.setPrice(Price.StringToEnum(dto.getPrice()));
		features.setCapacity(Capacity.StringToEnum(dto.getCapacity()));
		features.setAlcohol(dto.isAlcohol());
		features.setLiveMusic(dto.isLiveMusic());
		features.setOutdoorSeating(dto.isOutdoorSeating());
		features.setProgramForChildern(dto.isProgramForChiledern());
		features.setReservations(dto.isReservations());
		features.setTv(dto.isTv());
		features.setWifi(dto.isTv());
		features.setParking(dto.isParking());
		return features;
	}



}
