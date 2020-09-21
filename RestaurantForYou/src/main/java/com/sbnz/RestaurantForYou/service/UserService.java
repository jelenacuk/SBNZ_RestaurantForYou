package com.sbnz.RestaurantForYou.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.kie.api.runtime.KieSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.sbnz.RestaurantForYou.converter.RegistrationDTOConverter;
import com.sbnz.RestaurantForYou.dto.CommentDto;
import com.sbnz.RestaurantForYou.dto.RegistrationDTO;
import com.sbnz.RestaurantForYou.dto.ReviewDTO;
import com.sbnz.RestaurantForYou.events.RatingEvent;
import com.sbnz.RestaurantForYou.model.Comment;
import com.sbnz.RestaurantForYou.model.RegisteredUser;
import com.sbnz.RestaurantForYou.model.Restaurant;
import com.sbnz.RestaurantForYou.model.Review;
import com.sbnz.RestaurantForYou.model.User;
import com.sbnz.RestaurantForYou.repository.CommentRepository;
import com.sbnz.RestaurantForYou.repository.RestaurantRepository;
import com.sbnz.RestaurantForYou.repository.ReviewRepository;
import com.sbnz.RestaurantForYou.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	private RestaurantRepository restaurantRepository;
	private ReviewRepository reviewRepository;
	private CommentRepository commentRepository;
	private final KnowledgeService knowledgeService;

	public UserService(UserRepository userRepository, RestaurantRepository restaurantRepository,
			ReviewRepository reviewRepository, KnowledgeService knowledgeService, CommentRepository commentRepository) {
		this.userRepository = userRepository;
		this.restaurantRepository = restaurantRepository;
		this.reviewRepository = reviewRepository;
		this.knowledgeService = knowledgeService;
		this.commentRepository = commentRepository;
	}

	public boolean rateRestaurant(ReviewDTO dto) {

		Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId()).get();
		RegisteredUser loggedUser = getLoggedUser();

		boolean isRecommended = false;
		Review newReview = null;
		// check if the restaurant is on the recommended list
		for (Restaurant r : loggedUser.getRecommendedRestaurants()) {
			if (r.getId() == dto.getRestaurantId()) {
				isRecommended = true;
				// check if the user has already rated the restaurant
				for (Review review : r.getRestaurantReviews()) {
					if (review.getUser().getId() == loggedUser.getId()) {
						newReview = review;
						break;
					}
				}
				break;
			}
		}
		if (isRecommended) {
			if (newReview == null) {
				newReview = new Review(loggedUser, restaurant, dto.getRating(), LocalDate.now());
			} else {
				newReview.setRating(dto.getRating());
			}
			reviewRepository.save(newReview);
			restaurant.getRestaurantReviews().add(newReview);
			RatingEvent ratingEvent = new RatingEvent(new Date(), newReview);
			KieSession kieSession = knowledgeService.getEventsSession();
			kieSession.insert(ratingEvent);
			kieSession.getAgenda().getAgendaGroup("rating").setFocus();
			kieSession.fireAllRules();
			restaurantRepository.save(restaurant);
		}
		return isRecommended;
	}

	public CommentDto commentRestaurant(CommentDto dto) {

		Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId()).get();
		RegisteredUser loggedUser = getLoggedUser();
		boolean isRecommended = false;
		for (Restaurant r : loggedUser.getRecommendedRestaurants()) {
			if (r.getId() == dto.getRestaurantId()) {
				isRecommended = true;
				break;
			}
		}
		if (isRecommended) {
			Comment comment = new Comment(loggedUser, restaurant, dto.getText());
			restaurant.getRestaurantComments().add(comment);
			commentRepository.save(comment);
			restaurantRepository.save(restaurant);
			dto.setAuthorName(comment.getUser().getFirstName() + " " + comment.getUser().getLastName() + "("
					+ comment.getUser().getUsername() + ")");
		} else {
			dto = null;
		}
		return dto;
	}
	
	public boolean blockUser(String username) {
		User user = userRepository.findOneByUsername(username);
		user.setActive(false);
		userRepository.save(user);
		return true;
	}

	public List<RegistrationDTO> getUsers(Pageable pageable) {

		Page<User> users = userRepository.findAll(pageable);
		return (users.stream().map(user -> {
			RegistrationDTO dto = RegistrationDTOConverter.convertToDTO((RegisteredUser) user);
			dto.setSize(users.getTotalElements());
			return dto;
		})).collect(Collectors.toList());
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
