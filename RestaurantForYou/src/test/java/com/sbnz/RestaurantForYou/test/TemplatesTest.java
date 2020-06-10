package com.sbnz.RestaurantForYou.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.drools.template.ObjectDataCompiler;
import org.junit.jupiter.api.Test;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;

import com.sbnz.RestaurantForYou.model.RegisteredUser;
import com.sbnz.RestaurantForYou.model.Restaurant;
import com.sbnz.RestaurantForYou.model.Review;
import com.sbnz.RestaurantForYou.template.NumberOfVotes;
import com.sbnz.RestaurantForYou.template.RatingRange;

public class TemplatesTest {
	
	RegisteredUser user;
	Restaurant rest1;
	Restaurant rest2;
	Restaurant rest3;
	
	public void setUp() {
		
		user = new RegisteredUser();
		user.setId(101l);
		
		rest1 = new Restaurant();
		rest1.setId(101l);
		rest1.getResetaurantReviews().add(new Review(user, rest1, 1));
		rest1.getResetaurantReviews().add(new Review(user, rest1, 2));
		
		rest2 = new Restaurant();
		rest2.setId(102l);
		rest2.getResetaurantReviews().add(new Review(user, rest2, 2));
		rest2.getResetaurantReviews().add(new Review(user, rest2, 3));
		
		rest3 = new Restaurant();
		rest3.setId(103l);
		rest3.getResetaurantReviews().add(new Review(user, rest3, 3));
		rest3.getResetaurantReviews().add(new Review(user, rest3, 4));
	}
	
	@Test
	public void getRestaurantsByRatingRange() {
		
		setUp();
		InputStream template = TemplatesTest.class.getResourceAsStream("/templates/getRestaurantsByRatingRange.drt");
		ObjectDataCompiler converter = new ObjectDataCompiler();
		List<RatingRange> data = new ArrayList<RatingRange>();
		RatingRange ratingRange = new RatingRange(2, 3);
		data.add(ratingRange);
		String drl = converter.compile(data, template);
		KieSession kieSession = createKieSessionFromDRL(drl);
		
		List<Restaurant> result = new ArrayList<Restaurant>();
		kieSession.insert(rest1);
		kieSession.insert(rest2);
		kieSession.insert(rest3);
		kieSession.setGlobal("result", result);
		kieSession.fireAllRules();
		
		assertEquals(1, result.size());
		assertEquals(rest2.getId(), result.get(0).getId());
	}
	
	@Test
	public void getNumberOfVotesPerGrade() {
		
		setUp();
		InputStream template = TemplatesTest.class.getResourceAsStream("/templates/getNumberOfVotesPerGrade.drt");
		ObjectDataCompiler converter = new ObjectDataCompiler();
		List<NumberOfVotes> data = new ArrayList<NumberOfVotes>();
		NumberOfVotes numOfVotes = new NumberOfVotes(102l, 3);
		data.add(numOfVotes);
		String drl = converter.compile(data, template);
		KieSession kieSession = createKieSessionFromDRL(drl);
		List<Long> result = new ArrayList<Long>();
		kieSession.insert(rest2);
		kieSession.setGlobal("result", result);
		kieSession.fireAllRules();
		assertEquals(1, result.get(0));
	}
	
	private KieSession createKieSessionFromDRL(String drl){
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(drl, ResourceType.DRL);
        
        Results results = kieHelper.verify();
        
        if (results.hasMessages(Message.Level.WARNING, Message.Level.ERROR)){
            List<Message> messages = results.getMessages(Message.Level.WARNING, Message.Level.ERROR);
            for (Message message : messages) {
                System.out.println("Error: "+message.getText());
            }
            
            throw new IllegalStateException("Compilation errors were found. Check the logs.");
        }
        
        return kieHelper.build().newKieSession();
    }

}
