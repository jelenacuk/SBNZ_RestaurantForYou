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
import com.sbnz.RestaurantForYou.dto.StatisticsDTO;
import com.sbnz.RestaurantForYou.dto.UserExpectationsDTO;
import com.sbnz.RestaurantForYou.service.ReportService;
import com.sbnz.RestaurantForYou.service.RestaurantService;
import com.sbnz.RestaurantForYou.template.RatingRange;

@RestController
@RequestMapping("/api/restaraunts")
@CrossOrigin
public class RestaurantController {

	private RestaurantService restaurantService;
	private ReportService reportService;

	@Autowired
	public RestaurantController(RestaurantService restaurantService, ReportService reportService) {
		this.restaurantService = restaurantService;
		this.reportService = reportService;
	}
	
	@GetMapping(value = "reports/{numOfMonths}")
	public ResponseEntity<StatisticsDTO> samoProba(@PathVariable("numOfMonths") int numOfMonths) {
		StatisticsDTO dto = this.reportService.samoProba(numOfMonths);
		return new ResponseEntity<StatisticsDTO>(dto, HttpStatus.OK);
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
	
	@PostMapping(value = "/restaurantSugestion")
	public ResponseEntity<RestaurantDTO> reccomandation(@RequestBody UserExpectationsDTO dto) {
		RestaurantDTO restaurant = restaurantService.restaurantSugestion(dto);
		return new ResponseEntity<RestaurantDTO>(restaurant, HttpStatus.OK);
	}
	
	@PostMapping(value = "/getRestaurantsByRatingRange")
	public ResponseEntity<List<RestaurantDTO>> getRestaurantsByRatingRange(@RequestBody RatingRange dto) {
		List<RestaurantDTO> restaurants = restaurantService.getRestaurantsByRatingRange(dto);
		return new ResponseEntity<List<RestaurantDTO>>(restaurants, HttpStatus.OK);
	}
}
