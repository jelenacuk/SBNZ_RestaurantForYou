package com.sbnz.RestaurantForYou.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.drools.template.ObjectDataCompiler;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.sbnz.RestaurantForYou.converter.RestaurantDTOConverter;
import com.sbnz.RestaurantForYou.converter.RestaurantSetter;
import com.sbnz.RestaurantForYou.dto.ReportDTO;
import com.sbnz.RestaurantForYou.dto.RestaurantDTO;
import com.sbnz.RestaurantForYou.dto.SearchDto;
import com.sbnz.RestaurantForYou.dto.UserExpectationsDTO;
import com.sbnz.RestaurantForYou.model.RegisteredUser;
import com.sbnz.RestaurantForYou.model.Restaurant;
import com.sbnz.RestaurantForYou.model.RestaurantFeatures;
import com.sbnz.RestaurantForYou.model.RestaurantRrequirements;
import com.sbnz.RestaurantForYou.model.Review;
import com.sbnz.RestaurantForYou.repository.FeaturesRepository;
import com.sbnz.RestaurantForYou.repository.RestaurantRepository;
import com.sbnz.RestaurantForYou.repository.UserRepository;

@Service
public class RestaurantService {

	private RestaurantRepository repository;
	private KnowledgeService knowledgeService;
	private UserRepository userRepository;
	private FeaturesRepository featuresRepository;
	private RestaurantMatchingService matchingService;

	@Autowired
	public RestaurantService(RestaurantRepository repository, KnowledgeService knowledgeService,
			UserRepository userRepository, RestaurantMatchingService matchingService, FeaturesRepository featuresRepository) {
		this.repository = repository;
		this.knowledgeService = knowledgeService;
		this.userRepository = userRepository;
		this.matchingService = matchingService;
		this.featuresRepository = featuresRepository;
	}
	
	public RestaurantDTO restaurantSugestion(UserExpectationsDTO userExpectations) {

		KieSession kieSession = knowledgeService.getRulesSession();

		// Inserting restaurants to session
		RestaurantRrequirements restRequirements = new RestaurantRrequirements();
		List<Restaurant> restaurants = repository.findAllCompleted();
		for (Restaurant restaurant : restaurants) {
			kieSession.insert(restaurant);
		}
		kieSession.insert(restRequirements);
		kieSession.insert(userExpectations);

		// Applying rules to find restaurant's requirements
		kieSession.getAgenda().getAgendaGroup("requirments").setFocus();
		kieSession.fireAllRules();
		knowledgeService.releaseRulesSession();

		// Applying rules to find restaurant that fits best
		Restaurant bestRestaurant = findBestRestaurant(restaurants, restRequirements);
		RegisteredUser loggedUser = getLoggedUser();
		loggedUser.getRecommendedRestaurants().add(bestRestaurant);
		userRepository.save(loggedUser);
		return RestaurantDTOConverter.convertToDTO(bestRestaurant, null);
	}

	private Restaurant findBestRestaurant(List<Restaurant> restaurants, RestaurantRrequirements restRequirements) {

		// inserting data into session
		KieSession kieSession = knowledgeService.getRulesSession();
		for (Restaurant restaurant : restaurants) {
			kieSession.insert(restaurant);
		}
		kieSession.insert(restRequirements);
		kieSession.insert(matchingService);
		Restaurant bestRestaurant = null;
		kieSession.setGlobal("bestRestaurant", bestRestaurant);

		// firing rules for finding the best restaurant
		kieSession.getAgenda().getAgendaGroup("recommendation").setFocus();
		kieSession.fireAllRules();
		bestRestaurant = (Restaurant) kieSession.getGlobal("bestRestaurant");
		return bestRestaurant;
	}

	public List<RestaurantDTO> getRestoraunts(Pageable pageable) {

		Page<Restaurant> restaurants = repository.findCompletedRestaurants(pageable);
		return (restaurants.stream().map(restaurant -> {
			RestaurantDTO dto = RestaurantDTOConverter.convertToDTO(restaurant, new ReportDTO(0, 0));
			dto.setSize(restaurants.getTotalElements());
			return dto;
		})).collect(Collectors.toList());
	}

	public RestaurantDTO getRestaurant(Long id) {

		Optional<Restaurant> restaurantOpt = repository.findById(id);
		KieSession kieSession = knowledgeService.getRulesSession();
		kieSession.insert(restaurantOpt.get());

		RestaurantDTO restDTO = null;
		QueryResults results = kieSession.getQueryResults("User ratings", id);
		for (QueryResultsRow qrr : results) {

			// Retrieving values from drools query
			Restaurant restaurant = (Restaurant) qrr.get("$restaurant");
			long reviewNum = (long) qrr.get("$reviewNum");
			long ones = (long) qrr.get("$ones");
			long twos = (long) qrr.get("$twos");
			long threes = (long) qrr.get("$threes");
			long fours = (long) qrr.get("$fours");
			long fives = (long) qrr.get("$fives");
			int userReview = 0;
			RegisteredUser loggedUser = getLoggedUser();
			if (loggedUser != null) {
				for (Review review : restaurant.getRestaurantReviews()) {
					if (review.getUser().getId() == loggedUser.getId()) {
						userReview = review.getRating();
						break;
					}
				}
			}
			ReportDTO reportDTO = new ReportDTO(restaurant.getAverage(), reviewNum, ones, twos, threes, fours, fives,
					userReview);
			restDTO = RestaurantDTOConverter.convertToDTO(restaurant, reportDTO);
		}
		return restDTO;
	}

	
	public List<RestaurantDTO> search(SearchDto searchDto) {

		List<Restaurant> restaurants = repository.findAllCompleted();
		System.out.println("]tOVAKO = " + restaurants.size());
		List<Restaurant> result = new ArrayList<Restaurant>();
		if (!searchDto.getName().equals("")) {
			InputStream template = RestaurantService.class.getResourceAsStream("/templates/search.drt");
			ObjectDataCompiler converter = new ObjectDataCompiler();
			List<SearchDto> data = new ArrayList<>();
			data.add(searchDto);
			String drl = converter.compile(data, template);
			System.out.println("\n\n" + drl + "\n\n");
			KieSession kieSession = createKieSessionFromDRL(drl);
			for (Restaurant restaurant : restaurants) {
				if (restaurant.isComplete()) {
					kieSession.insert(restaurant);
				}
			}
			kieSession.setGlobal("result", result);
			kieSession.fireAllRules();
		} else {
			result = restaurants;
		}
		return (result.stream().map(restaurant -> {
			RestaurantDTO dto = RestaurantDTOConverter.convertToDTO(restaurant);
			return dto;
		})).collect(Collectors.toList());
	}
	
	public boolean updateRestaurant(RestaurantDTO dto) {
		Restaurant restaurant = repository.findById(dto.getId()).get();
		RestaurantFeatures features = RestaurantSetter.createFeatures(dto.getFeatures());
		restaurant.setFeatures(features);
		restaurant.setComplete(true);
		featuresRepository.save(features);
		repository.save(restaurant);
		return true;
	}
	
	public List<RestaurantDTO> incompleteRestaurants() {
		List<Restaurant> restaurants = repository.findAllInompleted();
		return (restaurants.stream().map(restaurant -> {
			RestaurantDTO dto = RestaurantDTOConverter.convertToDTO(restaurant, new ReportDTO(0, 0));
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
