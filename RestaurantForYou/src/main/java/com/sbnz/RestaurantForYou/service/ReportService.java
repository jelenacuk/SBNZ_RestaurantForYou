package com.sbnz.RestaurantForYou.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.drools.template.ObjectDataCompiler;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sbnz.RestaurantForYou.converter.RegistrationDTOConverter;
import com.sbnz.RestaurantForYou.converter.RestaurantDTOConverter;
import com.sbnz.RestaurantForYou.dto.DissatisfiedUsersDTO;
import com.sbnz.RestaurantForYou.dto.PopularityDTO;
import com.sbnz.RestaurantForYou.dto.ReportDTO;
import com.sbnz.RestaurantForYou.dto.RestaurantDTO;
import com.sbnz.RestaurantForYou.dto.UserRestaurantsDTO;
import com.sbnz.RestaurantForYou.model.RegisteredUser;
import com.sbnz.RestaurantForYou.model.Restaurant;
import com.sbnz.RestaurantForYou.model.User;
import com.sbnz.RestaurantForYou.repository.RestaurantRepository;
import com.sbnz.RestaurantForYou.repository.UserRepository;
import com.sbnz.RestaurantForYou.template.RatingRange;

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

	public PopularityDTO getPopularityReport(int numOfMonths) {

		// inserting data into session
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
		kSession.setGlobal("mostRecommendedRestaurant", mostRecommendedRestaurant);
		kSession.setGlobal("leastRecommendedRestaurant", leastRecommendedRestaurant);
		kSession.getAgenda().getAgendaGroup("popularity").setFocus();
		kSession.fireAllRules();
		// result
		mostRecommendedRestaurant = (Restaurant) kSession.getGlobal("mostRecommendedRestaurant");
		leastRecommendedRestaurant = (Restaurant) kSession.getGlobal("leastRecommendedRestaurant");
		PopularityDTO popularityDto = new PopularityDTO(RestaurantDTOConverter.convertToDTO(mostRecommendedRestaurant),
				RestaurantDTOConverter.convertToDTO(leastRecommendedRestaurant));
		return popularityDto;
	}

	public Set<DissatisfiedUsersDTO> getDissatisfiedUsers() {
		
		// inserting data into session
		KieSession kSession = knowledgeService.getRulesSession();
		List<User> users = userRepository.findAll();
		for (User user : users) {
			kSession.insert((RegisteredUser) user);
		}
		List<Restaurant> restaurants = restaurantRepository.findAll();
		for (Restaurant restaurant : restaurants) {
			kSession.insert(restaurant);
		}
		List<UserRestaurantsDTO> dissatisfiedUsers = new ArrayList<UserRestaurantsDTO>();
		// globals
		kSession.setGlobal("dissatisfiedUsers", dissatisfiedUsers);
		kSession.getAgenda().getAgendaGroup("dissatisfied").setFocus();
		kSession.fireAllRules();
		
		// result
		Set<DissatisfiedUsersDTO> dissatisfiedUsersList = new HashSet<DissatisfiedUsersDTO>();
		for (UserRestaurantsDTO item : dissatisfiedUsers) {
			DissatisfiedUsersDTO dto = new DissatisfiedUsersDTO();
			dto.setUser(RegistrationDTOConverter.convertToDTO(item.getUser()));
			for (Restaurant r : item.getRestaurants()) {
				dto.getRestaurants().add(RestaurantDTOConverter.convertToDTO(r));
			}
			dissatisfiedUsersList.add(dto);
		}
		return dissatisfiedUsersList;
	}

	public List<RestaurantDTO> getRestaurantsByRatingRange(RatingRange ratingRange) {
		// Creating KieSession and inserting rule from template
		InputStream template = RestaurantService.class
				.getResourceAsStream("/templates/getRestaurantsByRatingRange.drt");
		ObjectDataCompiler converter = new ObjectDataCompiler();
		List<RatingRange> data = new ArrayList<RatingRange>();
		data.add(ratingRange);
		String drl = converter.compile(data, template);
		System.out.println("\n\n" + drl + "\n\n");
		KieSession kieSession = createKieSessionFromDRL(drl);

		// Application of rules and collecting result
		List<Restaurant> result = new ArrayList<Restaurant>();
		for (Restaurant restaurant : restaurantRepository.findAll()) {
			kieSession.insert(restaurant);
		}
		kieSession.setGlobal("result", result);
		kieSession.fireAllRules();
		return (result.stream().map(restaurant -> {
			RestaurantDTO dto = RestaurantDTOConverter.convertToDTO(restaurant);
			return dto;
		})).collect(Collectors.toList());
	}

	public List<RestaurantDTO> getAlarms(Pageable pageable) {
		Page<Restaurant> restaurants = restaurantRepository.findAlaramedRestaurants(pageable);
		return (restaurants.stream().map(restaurant -> {
			RestaurantDTO dto = RestaurantDTOConverter.convertToDTO(restaurant,
					new ReportDTO(0, restaurant.getRestaurantReviews().size()));
			dto.setSize(restaurants.getTotalElements());
			return dto;
		})).collect(Collectors.toList());

	}

	private KieSession createKieSessionFromDRL(String drl) {
		KieHelper kieHelper = new KieHelper();
		kieHelper.addContent(drl, ResourceType.DRL);

		Results results = kieHelper.verify();

		if (results.hasMessages(Message.Level.WARNING, Message.Level.ERROR)) {
			List<Message> messages = results.getMessages(Message.Level.WARNING, Message.Level.ERROR);
			for (Message message : messages) {
				System.out.println("Error: " + message.getText());
			}

			throw new IllegalStateException("Compilation errors were found. Check the logs.");
		}

		return kieHelper.build().newKieSession();
	}
}
