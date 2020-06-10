package com.sbnz.RestaurantForYou.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sbnz.RestaurantForYou.events.FailedLogInEvent;
import com.sbnz.RestaurantForYou.model.RegisteredUser;

public class FailedLoginEventTest {
	
	RegisteredUser user;

	public void setUp() {
		user = new RegisteredUser();
		user.setId(101l);
	}
	
	//More than 5 logging in unsuccessfully in 2 minute from one user
	@Test
	public void failedLoginEventTest() {
			
		setUp();
			
		KieServices ks = KieServices.Factory.get();
	   	KieContainer kc = ks.newKieClasspathContainer();
	    KieSession ksession = kc.newKieSession("rulesSession");
	        
	    FailedLogInEvent event1 = new FailedLogInEvent(new Date(), user);
	    FailedLogInEvent event2 = new FailedLogInEvent(new Date(), user);
	    FailedLogInEvent event3 = new FailedLogInEvent(new Date(), user);
	    FailedLogInEvent event4 = new FailedLogInEvent(new Date(), user);
	    FailedLogInEvent event5 = new FailedLogInEvent(new Date(), user);
	    FailedLogInEvent event6 = new FailedLogInEvent(new Date(), user);
	        
	    ksession.insert(event1);
	    ksession.insert(event2);
	    ksession.insert(event3);
	    ksession.insert(event4);
	    ksession.insert(event5);
	    ksession.insert(event6);
	        
	    long ruleFireCount = ksession.fireAllRules();
	    assertEquals(1, ruleFireCount);
	}
}
