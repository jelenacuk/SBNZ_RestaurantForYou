package com.sbnz.RestaurantForYou.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sbnz.RestaurantForYou.converter.RestaurantDTOConverter;
import com.sbnz.RestaurantForYou.dto.RestaurantDTO;
import com.sbnz.RestaurantForYou.model.Restaurant;
import com.sbnz.RestaurantForYou.repository.RestaurantRepository;

@Service
public class RestaurantService {

	private RestaurantRepository repository;

	@Autowired
	public RestaurantService(RestaurantRepository repository) {
		this.repository = repository;
	}

	public RestaurantDTO getRestaurant(Long id) {
		Optional<Restaurant> restaurant = repository.findById(id);
		return RestaurantDTOConverter.convertToDTO(restaurant.get());
	}

	public List<RestaurantDTO> getRestoraunts(Pageable pageable) {
		Page<Restaurant> restaurants = repository.findAll(pageable);
		return (restaurants.stream().map(restaurant -> {
			RestaurantDTO dto = RestaurantDTOConverter.convertToDTO(restaurant);
			// set total size
			return dto;
		})).collect(Collectors.toList());
	}

	public boolean addNewRestaurant(RestaurantDTO dto) {
		// TO DO: provera validnosti radnog vremena
		Restaurant newRestaurant = RestaurantDTOConverter.convertFromDTO(dto);
		repository.save(newRestaurant);
		return true;
	}

}
