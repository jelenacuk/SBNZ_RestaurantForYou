package com.sbnz.RestaurantForYou.service;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.sbnz.RestaurantForYou.model.Ambience;
import com.sbnz.RestaurantForYou.model.Music;
import com.sbnz.RestaurantForYou.model.RegisteredUser;
import com.sbnz.RestaurantForYou.model.Restaurant;
import com.sbnz.RestaurantForYou.model.RestaurantRrequirements;
import com.sbnz.RestaurantForYou.repository.UserRepository;

@Service
public class RestaurantMatchingService {
	
	private UserRepository userRepository;
	
	
	public RestaurantMatchingService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public int calculateMatching(Restaurant restaurant, RestaurantRrequirements requerments) {
		int matching = 0;
		System.out.println(restaurant.getName().toUpperCase());
	
		if (requerments.getPrice().contains(restaurant.getFeatures().getPrice())) {
			System.out.println("\tMatch => PRICE");
			matching +=3;
		}
		if (requerments.getCapacity().contains(restaurant.getFeatures().getCapacity())) {
			System.out.println("\tMatch => CAPACITY");
			matching +=1;
		}
		for (String kitchen: requerments.getKitchen()) {
			for (String item: restaurant.getCuisine()) {
				if (item.equals(kitchen)) {
					System.out.println("\tMatch => KITCHEN " + kitchen);
					matching +=3;
					break;
				}
			}
		}
		for (Music music: requerments.getMusic()) {
			for (Music item: restaurant.getFeatures().getMusic()) {
				if (item.equals(music)) {
					System.out.println("\tMatch => MUSIC " + music);
					matching +=2;
					break;
				}
			}
		}
		for (Ambience ambience: requerments.getAmbience()) {
			for (Ambience item: restaurant.getFeatures().getAmbience()) {
				if (item.equals(ambience)) {
					System.out.println("\tMatch => AMBIENCE " + ambience);
					matching +=2;
					break;
				}
			}
		}
		if (requerments.getFeatures().isAlcohol() && restaurant.getFeatures().isAlcohol()) {
			System.out.println("\tMatch => ALCOHOL");
			matching +=1;
		}
		if (requerments.getFeatures().isLiveMusic() && restaurant.getFeatures().isLiveMusic()) {
			System.out.println("\tMatch => LIVE MUSIC");
			matching +=1;
		}
		if (requerments.getFeatures().isOutdoorSeating() && restaurant.getFeatures().isOutdoorSeating()) {
			System.out.println("\tMatch => BASTA");
			matching +=1;
		}
		if (requerments.getFeatures().isParking() && restaurant.getFeatures().isParking()) {
			System.out.println("\tMatch => PARKING");
			matching +=1;
		}
		if (requerments.getFeatures().isProgramForChildern() && restaurant.getFeatures().isProgramForChildern()) {
			System.out.println("\tMatch => CHILDERN");
			matching +=1;
		}
		if (requerments.getFeatures().isReservations() && restaurant.getFeatures().isReservations()) {
			System.out.println("\tMatch => RESERVATION");
			matching +=1;
		}
		if (requerments.getFeatures().isTv() && restaurant.getFeatures().isTv()) {
			System.out.println("\tMatch => TV");
			matching +=1;
		}
		if (requerments.getFeatures().isWifi() && restaurant.getFeatures().isWifi()) {
			System.out.println("\tMatch => WIFI");
			matching +=1;
		}
		RegisteredUser loggedUser = getLoggedUser();
		if (loggedUser.getRecommendedRestaurants().contains(restaurant)) {
			matching = matching - 5;
		}
		restaurant.setScore(matching);
		System.out.println("matching = " + matching);
		return matching;
	}
	
	// Returns currently logged user
	private RegisteredUser getLoggedUser() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken) && authentication != null) {
			String username = authentication.getName();
			return (RegisteredUser) userRepository.findOneByUsername(username);
		}
		return null;
	}

}
