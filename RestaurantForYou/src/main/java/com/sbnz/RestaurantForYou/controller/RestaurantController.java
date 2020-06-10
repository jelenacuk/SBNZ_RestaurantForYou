package com.sbnz.RestaurantForYou.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.RestaurantForYou.dto.RestaurantDTO;
import com.sbnz.RestaurantForYou.dto.UserExpectationsDTO;
import com.sbnz.RestaurantForYou.service.RestaurantService;
import com.sbnz.RestaurantForYou.template.RatingRange;

@RestController
@RequestMapping("/api/restaraunts")
@CrossOrigin
public class RestaurantController {

	private RestaurantService restaurantService;

	@Autowired
	public RestaurantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<RestaurantDTO> getRestaurant(@PathVariable("id") Long id) {
		RestaurantDTO restaurant = restaurantService.getRestaurant(id);
		return new ResponseEntity<RestaurantDTO>(restaurant, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<RestaurantDTO>> getRestaurants(Pageable pageable){
		List<RestaurantDTO> restaurants = restaurantService.getRestoraunts(pageable);
		return new ResponseEntity<List<RestaurantDTO>>(restaurants, HttpStatus.OK);
	}

	@PostMapping(value = "/addRestaurant")
	public ResponseEntity<Boolean> addNewRestaurant(@RequestBody RestaurantDTO dto) throws FileNotFoundException, IOException {
		boolean result = restaurantService.addNewRestaurant(dto);
		if (result) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(value = "/restaurantRecommandation")
	public ResponseEntity<List<RestaurantDTO>> reccomandation(@RequestBody UserExpectationsDTO dto) {
		List<RestaurantDTO> restaurants = restaurantService.recommandRestaurant(dto);
		return new ResponseEntity<List<RestaurantDTO>>(restaurants, HttpStatus.OK);
	}
	
	@PostMapping(value = "/getRestaurantsByRatingRange")
	public ResponseEntity<List<RestaurantDTO>> getRestaurantsByRatingRange(@RequestBody RatingRange dto) {
		List<RestaurantDTO> restaurants = restaurantService.getRestaurantsByRatingRange(dto);
		return new ResponseEntity<List<RestaurantDTO>>(restaurants, HttpStatus.OK);
	}
}
