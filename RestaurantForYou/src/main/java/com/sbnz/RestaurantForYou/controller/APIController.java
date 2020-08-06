package com.sbnz.RestaurantForYou.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.RestaurantForYou.service.APIService;

@RestController
@RequestMapping("/api/myapi")
public class APIController {
	
	private APIService apiService;
	
	public APIController(APIService apiService) {
		this.apiService = apiService;
	}
	
	@GetMapping
	public void getResponse() {
		apiService.getRestaurants();
	}

}
