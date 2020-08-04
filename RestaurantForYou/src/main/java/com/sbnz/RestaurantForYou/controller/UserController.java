package com.sbnz.RestaurantForYou.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.RestaurantForYou.dto.ReviewDTO;
import com.sbnz.RestaurantForYou.service.UserService;

@RestController
@RequestMapping("/api/user")
@PreAuthorize("hasAuthority('ROLE_REGISTERED')")
@CrossOrigin
public class UserController {
	
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@PostMapping(value = "/rate")
	public ResponseEntity<Boolean> rateRestaurant(@RequestBody ReviewDTO dto) {
		boolean result = this.userService.rateRestaurant(dto);
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}

}
