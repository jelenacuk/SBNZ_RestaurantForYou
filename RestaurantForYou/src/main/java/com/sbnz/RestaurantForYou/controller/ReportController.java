package com.sbnz.RestaurantForYou.controller;

import java.util.List;
import java.util.Set;

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

import com.sbnz.RestaurantForYou.dto.DissatisfiedUsersDTO;
import com.sbnz.RestaurantForYou.dto.PopularityDTO;
import com.sbnz.RestaurantForYou.dto.RestaurantDTO;
import com.sbnz.RestaurantForYou.service.ReportService;
import com.sbnz.RestaurantForYou.template.RatingRange;

@RestController
@RequestMapping("/api/reports")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@CrossOrigin
public class ReportController {

	private ReportService reportService;

	@Autowired
	public ReportController( ReportService reportService) {
		this.reportService = reportService;
	}
	
	@GetMapping(value = "/popularityReport/{numOfMonths}")
	public ResponseEntity<PopularityDTO> getPopularityReport(@PathVariable("numOfMonths") int numOfMonths) {
		PopularityDTO dto = this.reportService.getPopularityReport(numOfMonths);
		return new ResponseEntity<PopularityDTO>(dto, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getDissatisfiedUsers")
	public ResponseEntity<Set<DissatisfiedUsersDTO>> getDissatisfiedUsers() {
		Set<DissatisfiedUsersDTO> dtoList = this.reportService.getDissatisfiedUsers();
		return new ResponseEntity<Set<DissatisfiedUsersDTO>>(dtoList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAlarms")
	public ResponseEntity<List<RestaurantDTO>> getAlarms(Pageable pageable){
		List<RestaurantDTO> restaurants = reportService.getAlarms(pageable);
		return new ResponseEntity<List<RestaurantDTO>>(restaurants, HttpStatus.OK);
	}
	
	@PostMapping(value = "/getRestaurantsByRatingRange")
	public ResponseEntity<List<RestaurantDTO>> getRestaurantsByRatingRange(@RequestBody RatingRange dto) {
		List<RestaurantDTO> restaurants = reportService.getRestaurantsByRatingRange(dto);
		return new ResponseEntity<List<RestaurantDTO>>(restaurants, HttpStatus.OK);
	}
}
