package com.sbnz.RestaurantForYou.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sbnz.RestaurantForYou.events.RatingEvent;
import com.sbnz.RestaurantForYou.model.RegisteredUser;
import com.sbnz.RestaurantForYou.model.Restaurant;
import com.sbnz.RestaurantForYou.model.Review;

public class BadRatingEventTest {
	
	RegisteredUser user;
	Restaurant restaurant;
	Review review1;
	Review review2;
	Review review3;
	Review review4;
	Review review5;
	
	public void setUp() {
		user = new RegisteredUser();
		user.setId(101l);
		restaurant = new Restaurant();
		restaurant.setId(101l);
		restaurant.setName("restaurant");
		review1 = new Review(user,null, 4, new Date());
		review2 = new Review(user, null, 2, new Date());
		review3 = new Review(user, null, 1, new Date());
		review4 = new Review(user, null, 2, new Date());
		review5 = new Review(user, null, 1, new Date());
		restaurant.getResetaurantReviews().add(review1);
		restaurant.getResetaurantReviews().add(review2);
		restaurant.getResetaurantReviews().add(review3);
		restaurant.getResetaurantReviews().add(review4);
		restaurant.getResetaurantReviews().add(review5);
		review1.setRestaurant(restaurant);
		review2.setRestaurant(restaurant);
		review3.setRestaurant(restaurant);
		review4.setRestaurant(restaurant);
		review5.setRestaurant(restaurant);
	}
	
	//The restaurant rating is below 2.5 a minimum of 5 users rated it
	@Test
	 public void badratingEventTest() {
		
		setUp();
		
		KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession("rulesSession");

        RatingEvent event1 = new RatingEvent(new Date(), review1);
        RatingEvent event2 = new RatingEvent(new Date(), review2);
        RatingEvent event3 = new RatingEvent(new Date(), review3);
        RatingEvent event4 = new RatingEvent(new Date(), review4);
        RatingEvent event5 = new RatingEvent(new Date(), review5);
        ksession.insert(event1);
        ksession.insert(event2);
        ksession.insert(event3);
        ksession.insert(event4);
        ksession.insert(event5);
        
        ksession.getAgenda().getAgendaGroup("rating").setFocus();
        long ruleFireCount = ksession.fireAllRules();
        assertEquals(1, ruleFireCount);
	 }

}
