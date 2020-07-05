package com.sbnz.RestaurantForYou.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sbnz.RestaurantForYou.dto.UserExpectationsDTO;
import com.sbnz.RestaurantForYou.model.Ambience;
import com.sbnz.RestaurantForYou.model.Capacity;
import com.sbnz.RestaurantForYou.model.Kitchen;
import com.sbnz.RestaurantForYou.model.Music;
import com.sbnz.RestaurantForYou.model.Price;
import com.sbnz.RestaurantForYou.model.RegisteredUser;
import com.sbnz.RestaurantForYou.model.Restaurant;
import com.sbnz.RestaurantForYou.model.RestaurantFeatures;
import com.sbnz.RestaurantForYou.model.RestaurantRrequirements;

public class RestaurantRecommendationTest {

	RegisteredUser user;
	Restaurant rest1;
	UserExpectationsDTO expectations;
	
public void setUp() {
		
		user = new RegisteredUser();
		user.setId(101l);
		
		rest1 = new Restaurant();
		rest1.setId(101l);
		rest1.setAmbience(Ambience.CHEERFUL);
		rest1.setMusic(Music.TAMBURITZA);
		rest1.setCapacity(Capacity.MEDIUM);
		rest1.setKitchen(Kitchen.ITALIAN);
		rest1.setPrice(Price.AFFORDABLE);
		RestaurantFeatures features = new RestaurantFeatures();
		features.setAlcohol(true);
		features.setLiveMusic(true);
		features.setOutdoorSeating(false);
		features.setParking(false);
		features.setProgramForChildern(false);
		features.setReservations(true);
		features.setTv(false);
		features.setWifi(true);
		rest1.setFeatures(features);
		
		expectations = new UserExpectationsDTO();
		expectations.setCompany("Partner");
		expectations.setKitchen("Italian");
		expectations.setMusic("Classical");
		expectations.setOccasion("Special");
		expectations.setPrice("Cheap");
		expectations.setNumOfPeople(2);
		expectations.setOnFoot("No");
		expectations.setWeather("spring");
	}

	@Test
	public void test() {
		
		setUp();
		
		KieServices ks = KieServices.Factory.get();
    	KieContainer kc = ks.newKieClasspathContainer();
        KieSession ksession = kc.newKieSession("rulesSession");
        
        RestaurantRrequirements restRequirements = new RestaurantRrequirements();
        ksession.insert(rest1);
        ksession.insert(expectations);
        ksession.insert(restRequirements);
        ksession.getAgenda().getActivationGroup("requirments");
        long ruleFireCount = ksession.fireAllRules();
        ksession.dispose();
        
        ksession = kc.newKieSession("rulesSession");
        ksession.insert(rest1);
        ksession.insert(expectations);
        ksession.insert(restRequirements);
        ksession.getAgenda().getActivationGroup("recommendation");
        ruleFireCount += ksession.fireAllRules();
        
        //Rules should come to the following conclusions for restaurantRequirments
        assertEquals(true, restRequirements.getFeatures().isAlcohol());
        assertEquals(true, restRequirements.getFeatures().isLiveMusic());
        assertEquals(true, restRequirements.getFeatures().isReservations());
        assertEquals(true, restRequirements.getFeatures().isOutdoorSeating());
        assertEquals(true, restRequirements.getFeatures().isParking());
        assertTrue(restRequirements.getAmbience().contains(Ambience.CHEERFUL));
        assertTrue(restRequirements.getAmbience().contains(Ambience.ROMANTIC));
        assertTrue(restRequirements.getPrice().contains(Price.CHEAP));
        assertTrue(restRequirements.getKitchen().contains(Kitchen.ITALIAN));
        assertTrue(restRequirements.getMusic().contains(Music.CLASSICAL));
        //After scoring similarity with requirements
       assertEquals(8, rest1.getScore());
       assertEquals(12, ruleFireCount); 
	}
}
