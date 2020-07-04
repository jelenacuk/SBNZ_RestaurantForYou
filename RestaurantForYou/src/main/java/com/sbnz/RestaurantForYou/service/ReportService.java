package com.sbnz.RestaurantForYou.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import com.sbnz.RestaurantForYou.converter.RegistrationDTOConverter;
import com.sbnz.RestaurantForYou.converter.RestaurantDTOConverter;
import com.sbnz.RestaurantForYou.dto.DissatisfiedUsersDTO;
import com.sbnz.RestaurantForYou.dto.StatisticsDTO;
import com.sbnz.RestaurantForYou.dto.UserRestaurantsDTO;
import com.sbnz.RestaurantForYou.model.RegisteredUser;
import com.sbnz.RestaurantForYou.model.Restaurant;
import com.sbnz.RestaurantForYou.model.User;
import com.sbnz.RestaurantForYou.repository.RestaurantRepository;
import com.sbnz.RestaurantForYou.repository.UserRepository;

@Service
public class ReportService {

	private RestaurantRepository restaurantRepository;
	private KnowledgeService knowledgeService;
	private UserRepository userRepository;

	public ReportService(RestaurantRepository restaurantRepository, KnowledgeService knowledgeService,
			UserRepository userRepository) {
		this.restaurantRepository = restaurantRepository;
		this.knowledgeService = knowledgeService;
		this.userRepository = userRepository;
	}

	public StatisticsDTO samoProba(int numOfMonths) {

		KieSession kSession = knowledgeService.getRulesSession();
		List<User> users = userRepository.findAll();
		for (User user : users) {
			kSession.insert((RegisteredUser) user);
		}
		List<Restaurant> restaurants = restaurantRepository.findAll();
		for (Restaurant restaurant : restaurants) {
			kSession.insert(restaurant);
		}
		
		// globals
		Restaurant mostRecommendedRestaurant = null;
		Restaurant leastRecommendedRestaurant = null;
		List<UserRestaurantsDTO> dissatisfiedUsers = new ArrayList<UserRestaurantsDTO>();

		kSession.setGlobal("mostRecommendedRestaurant", mostRecommendedRestaurant);
		kSession.setGlobal("leastRecommendedRestaurant", leastRecommendedRestaurant);
		kSession.setGlobal("dissatisfiedUsers", dissatisfiedUsers);

		kSession.getAgenda().getAgendaGroup("reports").setFocus();
		kSession.fireAllRules();
		
		mostRecommendedRestaurant = (Restaurant) kSession.getGlobal("mostRecommendedRestaurant");
		leastRecommendedRestaurant = (Restaurant) kSession.getGlobal("leastRecommendedRestaurant");

		Set<DissatisfiedUsersDTO> dissatisfiedUsersList = new HashSet<DissatisfiedUsersDTO>();
		for (UserRestaurantsDTO item : dissatisfiedUsers) {
			DissatisfiedUsersDTO dto = new DissatisfiedUsersDTO();
			dto.setUser(RegistrationDTOConverter.convertToDTO(item.getUser()));
			for (Restaurant r : item.getRestaurants()) {
				dto.getRestaurants().add(RestaurantDTOConverter.convertToDTO(r, null));
			}
			dissatisfiedUsersList.add(dto);
		}

		StatisticsDTO statisticDTO = new StatisticsDTO(
				RestaurantDTOConverter.convertToDTO(mostRecommendedRestaurant, null),
				RestaurantDTOConverter.convertToDTO(leastRecommendedRestaurant, null), 
				dissatisfiedUsersList);

		return statisticDTO;
	}
}
