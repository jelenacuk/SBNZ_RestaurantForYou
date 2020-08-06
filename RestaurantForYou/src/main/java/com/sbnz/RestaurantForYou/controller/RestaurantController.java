package com.sbnz.RestaurantForYou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.sbnz.RestaurantForYou.dto.RestaurantDTO;
import com.sbnz.RestaurantForYou.dto.SearchDto;
import com.sbnz.RestaurantForYou.dto.UserExpectationsDTO;
import com.sbnz.RestaurantForYou.service.RestaurantService;

@RestController
@RequestMapping("/api/restaraunts")
@CrossOrigin
public class RestaurantController {
	
	private RestaurantService restaurantService;

	@Autowired
	public RestaurantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
	
	
	@GetMapping
	public ResponseEntity<List<RestaurantDTO>> getRestaurants(Pageable pageable){
		List<RestaurantDTO> restaurants = restaurantService.getRestoraunts(pageable);
		return new ResponseEntity<List<RestaurantDTO>>(restaurants, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<RestaurantDTO> getRestaurant(@PathVariable("id") Long id) {
		RestaurantDTO restaurant = restaurantService.getRestaurant(id);
		return new ResponseEntity<RestaurantDTO>(restaurant, HttpStatus.OK);
	}

	@PostMapping(value = "/search")
	public ResponseEntity<List<RestaurantDTO>> search(@RequestBody SearchDto dto) {
		List<RestaurantDTO> restaurants = restaurantService.search(dto);
		return new ResponseEntity<List<RestaurantDTO>>(restaurants, HttpStatus.OK);
	}
	
	@PostMapping(value = "/restaurantSugestion")
	@PreAuthorize("hasAuthority('ROLE_REGISTERED')")
	public ResponseEntity<RestaurantDTO> reccomandation(@RequestBody UserExpectationsDTO dto) {
		RestaurantDTO restaurant = restaurantService.restaurantSugestion(dto);
		return new ResponseEntity<RestaurantDTO>(restaurant, HttpStatus.OK);
	}
	
}
