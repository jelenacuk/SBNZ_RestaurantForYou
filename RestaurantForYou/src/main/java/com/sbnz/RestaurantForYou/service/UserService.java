package com.sbnz.RestaurantForYou.service;

import java.util.Date;

import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.sbnz.RestaurantForYou.dto.ReviewDTO;
import com.sbnz.RestaurantForYou.events.RatingEvent;
import com.sbnz.RestaurantForYou.model.RegisteredUser;
import com.sbnz.RestaurantForYou.model.Restaurant;
import com.sbnz.RestaurantForYou.model.Review;
import com.sbnz.RestaurantForYou.repository.RestaurantRepository;
import com.sbnz.RestaurantForYou.repository.ReviewRepository;
import com.sbnz.RestaurantForYou.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	private RestaurantRepository restaurantRepository;
	private ReviewRepository reviewRepository;
	private final KieContainer kieContainer;

	public UserService(UserRepository userRepository, RestaurantRepository restaurantRepository,
			ReviewRepository reviewRepository, KieContainer kieContainer) {
		this.userRepository = userRepository;
		this.restaurantRepository = restaurantRepository;
		this.reviewRepository = reviewRepository;
		this.kieContainer = kieContainer;
	}

	public boolean rateRestaurant(ReviewDTO dto) {

		Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId()).get();
		RegisteredUser loggedUser = getLoggedUser();
		Review review = new Review(loggedUser, restaurant, dto.getRating());
		reviewRepository.save(review);
		restaurant.getResetaurantReviews().add(review);
		restaurantRepository.save(restaurant);
		RatingEvent ratingEvent = new RatingEvent(new Date(), review);
		KieSession kieSession = getKieSession();
		kieSession.insert(ratingEvent);
		kieSession.getAgenda().getAgendaGroup("rating").setFocus();
		kieSession.fireAllRules();
		return true;

	}
	
	// Returns currently logged user
	private RegisteredUser getLoggedUser() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String username = authentication.getName();
			return (RegisteredUser) userRepository.findOneByUsername(username);
		}
		return null;
	}
	
	private KieSession getKieSession() {
		KieServices ks = KieServices.Factory.get();
		KieBaseConfiguration kbconf = ks.newKieBaseConfiguration();
		kbconf.setOption(EventProcessingOption.STREAM);
		KieBase kbase = kieContainer.newKieBase(kbconf);
		KieSession kieSession = kbase.newKieSession();
		return kieSession;
	}
	

}
