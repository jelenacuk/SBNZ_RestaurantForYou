package com.sbnz.RestaurantForYou.service;

import java.time.LocalDate;
import java.util.Date;

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
	private final KnowledgeService knowledgeService;

	public UserService(UserRepository userRepository, RestaurantRepository restaurantRepository,
			ReviewRepository reviewRepository, KnowledgeService knowledgeService) {
		this.userRepository = userRepository;
		this.restaurantRepository = restaurantRepository;
		this.reviewRepository = reviewRepository;
		this.knowledgeService = knowledgeService;
	}

	public boolean rateRestaurant(ReviewDTO dto) {

		Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId()).get();
		RegisteredUser loggedUser = getLoggedUser();
		boolean ok = false;
		Review newReview = null;
		for (Restaurant r : loggedUser.getRecommendedRestaurants()) {
			if (r.getId() == dto.getRestaurantId()){
				ok = true;
				for (Review review: r.getRestaurantReviews()) {
					if (review.getUser().getId() == loggedUser.getId()) {
						newReview = review;
						break;
					}
				}
				break;
			}
		}
		if (ok) {
			if (newReview == null) {
				newReview = new Review(loggedUser, restaurant, dto.getRating(), LocalDate.now());
			}
			else {
				newReview.setRating(dto.getRating());
			}
			reviewRepository.save(newReview);
			restaurant.getResetaurantReviews().add(newReview);
			restaurantRepository.save(restaurant);
			RatingEvent ratingEvent = new RatingEvent(new Date(), newReview);
			KieSession kieSession = knowledgeService.getEventsSession();
			kieSession.insert(ratingEvent);
			kieSession.getAgenda().getAgendaGroup("rating").setFocus();
			kieSession.fireAllRules();
		}
		return ok;
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
	
	

}
