package com.sbnz.RestaurantForYou.converter;

import java.util.stream.Collectors;

import com.sbnz.RestaurantForYou.dto.ContactInfoDTO;
import com.sbnz.RestaurantForYou.dto.LocationDTO;
import com.sbnz.RestaurantForYou.dto.ReportDTO;
import com.sbnz.RestaurantForYou.dto.RestaurantDTO;
import com.sbnz.RestaurantForYou.dto.RestaurantFeaturesDTO;
import com.sbnz.RestaurantForYou.model.ContactInfo;
import com.sbnz.RestaurantForYou.model.Location;
import com.sbnz.RestaurantForYou.model.Restaurant;
import com.sbnz.RestaurantForYou.model.RestaurantFeatures;

public class RestaurantDTOConverter {

	public static RestaurantDTO convertToDTO(Restaurant restaurant) {

		RestaurantDTO dto = new RestaurantDTO();
		dto.setId(restaurant.getId());
		dto.setName(restaurant.getName());
		dto.setDescription(restaurant.getDescription());
		dto.setPhoto(restaurant.getPhoto());
		dto.setClosed(restaurant.getClosed());
		dto.setOpenNowText(restaurant.getOpenNowText());
		dto.setCuisine(restaurant.getCuisine());
		dto.setDietaryRestrictions(restaurant.getDietaryRestrictions());
		if (restaurant.getPrice() != null) {
			dto.setPrice(restaurant.getPrice().toString());
		}
		dto.setFeatures(convertFeaturesToDTO(restaurant.getFeatures()));
		if (restaurant.getLocation() != null) {
			dto.setLocation(RestaurantDTOConverter.convertLocationToDTO(restaurant.getLocation()));
		}
		if (restaurant.getContact() != null) {
			dto.setContact(convertContactToDTO(restaurant.getContact()));
		}
		dto.setAlarmCreation(restaurant.getAlarm());
		if (restaurant.getAverage() != null) {
			dto.setAverageGrade(restaurant.getAverage());
		}
		return dto;

	}

	public static RestaurantDTO convertToDTO(Restaurant restaurant, ReportDTO reportDTO) {
		RestaurantDTO dto = RestaurantDTOConverter.convertToDTO(restaurant);
		dto.setReportDTO(reportDTO);
		return dto;

	}

	public static RestaurantFeaturesDTO convertFeaturesToDTO(RestaurantFeatures features) {
		RestaurantFeaturesDTO dto = new RestaurantFeaturesDTO();
		dto.setAlcohol(features.isAlcohol());
		dto.setLiveMusic(features.isLiveMusic());
		dto.setOutdoorSeating(features.isOutdoorSeating());
		dto.setProgramForChiledern(features.isProgramForChildern());
		dto.setReservations(features.isReservations());
		dto.setTv(features.isTv());
		dto.setWifi(features.isTv());
		dto.setParking(features.isParking());
		dto.setCapacity(features.getCapacity().toString());
		dto.setAmbience(
				features.getAmbience().stream().map(ambience -> ambience.toString()).collect(Collectors.toList()));
		dto.setMusic(features.getMusic().stream().map(music -> music.toString()).collect(Collectors.toList()));
		return dto;
	}

	public static LocationDTO convertLocationToDTO(Location location) {
		LocationDTO dto = new LocationDTO(location.getAddress(), location.getLatitude(), location.getLongitude());
		return dto;
	}

	public static ContactInfoDTO convertContactToDTO(ContactInfo contact) {
		ContactInfoDTO dto = new ContactInfoDTO(contact.getPhone(), contact.getEmail(), contact.getWebsite());
		return dto;
	}

}
