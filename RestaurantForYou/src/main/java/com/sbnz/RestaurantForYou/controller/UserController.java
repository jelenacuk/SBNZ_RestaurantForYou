package com.sbnz.RestaurantForYou.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.RestaurantForYou.dto.CommentDto;
import com.sbnz.RestaurantForYou.dto.RegistrationDTO;
import com.sbnz.RestaurantForYou.dto.ReviewDTO;
import com.sbnz.RestaurantForYou.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
	
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@PostMapping(value = "/rate")
	@PreAuthorize("hasAuthority('ROLE_REGISTERED')")
	public ResponseEntity<Boolean> rateRestaurant(@RequestBody ReviewDTO dto) {
		boolean result = this.userService.rateRestaurant(dto);
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
	
	@PostMapping(value = "/comment")
	@PreAuthorize("hasAuthority('ROLE_REGISTERED')")
	public ResponseEntity<CommentDto> commentRestaurant(@RequestBody CommentDto dto) {
		CommentDto result = this.userService.commentRestaurant(dto);
		return new ResponseEntity<CommentDto>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "/blockUser/{username}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<Boolean> getRestaurants(@PathVariable("username") String username){
		boolean result = userService.blockUser(username);
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<RegistrationDTO>> getUsers(Pageable pageable) {
		List<RegistrationDTO> users = userService.getUsers(pageable);
		return new ResponseEntity<List<RegistrationDTO>>(users, HttpStatus.OK);
	}

}
