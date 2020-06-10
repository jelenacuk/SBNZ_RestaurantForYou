package com.sbnz.RestaurantForYou.converter;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import com.sbnz.RestaurantForYou.dto.ReportDTO;
import com.sbnz.RestaurantForYou.dto.RestaurantDTO;
import com.sbnz.RestaurantForYou.dto.RestaurantFeaturesDTO;
import com.sbnz.RestaurantForYou.dto.WorkingDayDTO;
import com.sbnz.RestaurantForYou.model.Ambience;
import com.sbnz.RestaurantForYou.model.Capacity;
import com.sbnz.RestaurantForYou.model.Kitchen;
import com.sbnz.RestaurantForYou.model.Location;
import com.sbnz.RestaurantForYou.model.Music;
import com.sbnz.RestaurantForYou.model.Price;
import com.sbnz.RestaurantForYou.model.Restaurant;
import com.sbnz.RestaurantForYou.model.RestaurantFeatures;
import com.sbnz.RestaurantForYou.model.WorkingDay;

public class RestaurantDTOConverter {

	public static Restaurant convertFromDTO(RestaurantDTO dto) {

		Restaurant restaurant = new Restaurant();
		restaurant.setName(dto.getName());
		restaurant.setCapacity(Capacity.StringToEnum(dto.getCapacity()));
		restaurant.setAmbience(Ambience.StringToEnum(dto.getAmbience()));
		restaurant.setMusic(Music.StringToEnum(dto.getMusic()));
		restaurant.setKitchen(Kitchen.StringToEnum(dto.getKitchen()));
		restaurant.setPrice(Price.StringToEnum(dto.getPrice()));
		restaurant.setDescription(dto.getDescription());
		Location location = new Location(dto.getStreet(), dto.getNumber(), dto.getLatitude(), dto.getLongitude());
		restaurant.setLocation(location);
		restaurant.setFeatures(convertFeaturesFromDTO(dto.getFeatures()));
		Map<String, WorkingDay> workingDaysMap = new HashMap<String, WorkingDay>();
		for (WorkingDayDTO dayTime : dto.getWorkingDays()) {
			workingDaysMap.put(dayTime.getDay(), new WorkingDay(dayTime.getDay(), dayTime.isOpen(),
					LocalTime.parse(dayTime.getOpeningTime()), LocalTime.parse(dayTime.getClosingTime())));
		}
		restaurant.setWorkingDays(workingDaysMap);

		return restaurant;

	}

	// TO DO: vrati i redno vreme
	public static RestaurantDTO convertToDTO(Restaurant restaurant, ReportDTO reportDTO) {
		RestaurantDTO dto = new RestaurantDTO();
		dto.setAmbience(restaurant.getAmbience().toString());
		dto.setCapacity(restaurant.getCapacity().toString());
		dto.setKitchen(restaurant.getKitchen().toString());
		dto.setMusic(restaurant.getMusic().toString());
		dto.setName(restaurant.getName());
		dto.setPrice(restaurant.getPrice().toString());
		dto.setLatitude(restaurant.getLocation().getLatitude());
		dto.setLongitude(restaurant.getLocation().getLongitude());
		dto.setStreet(restaurant.getLocation().getStreet());
		dto.setNumber(restaurant.getLocation().getNumber());
		dto.setImage(restaurant.getImage());
		dto.setId(restaurant.getId());
		dto.setDescription(restaurant.getDescription());
		for (WorkingDay workingDay : restaurant.getWorkingDays().values()) {
			dto.getWorkingDays().add(convertWorkingDay(workingDay));
		}
		dto.setFeatures(convertFeaturesToDTO(restaurant.getFeatures()));
		dto.setReportDTO(reportDTO);
		return dto;

	}
	
	private static RestaurantFeaturesDTO convertFeaturesToDTO( RestaurantFeatures features) {
		RestaurantFeaturesDTO dto = new RestaurantFeaturesDTO();
		dto.setAlcohol(features.isAlcohol());
		dto.setLiveMusic(features.isLiveMusic());
		dto.setOutdoorSeating(features.isOutdoorSeating());
		dto.setProgramForChiledern(features.isProgramForChildern());
		dto.setReservations(features.isReservations());
		dto.setTv(features.isTv());
		dto.setWifi(features.isTv());
		dto.setParking(features.isParking());
		return dto;
	}
	
	private static RestaurantFeatures convertFeaturesFromDTO( RestaurantFeaturesDTO dto) {
		RestaurantFeatures features = new RestaurantFeatures();
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

	private static WorkingDayDTO convertWorkingDay(WorkingDay workingDay) {
		WorkingDayDTO dto = new WorkingDayDTO();
		dto.setDay(workingDay.getDay());
		dto.setOpen(workingDay.isOpen());
		dto.setOpeningTime(workingDay.getOpeningTime().toString());
		dto.setClosingTime(workingDay.getClosingTime().toString());
		return dto;
	}

}
