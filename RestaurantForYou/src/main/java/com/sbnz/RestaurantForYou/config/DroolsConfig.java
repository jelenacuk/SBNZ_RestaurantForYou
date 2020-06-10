package com.sbnz.RestaurantForYou.config;


import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {

	@Bean
	public KieContainer getKieContainer() {
		return KieServices.Factory.get().getKieClasspathContainer();
	}
	

}
