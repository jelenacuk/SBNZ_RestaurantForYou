package com.sbnz.RestaurantForYou.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.codec.Base64;
import com.sbnz.RestaurantForYou.converter.RestaurantDTOConverter;
import com.sbnz.RestaurantForYou.dto.RestaurantDTO;
import com.sbnz.RestaurantForYou.dto.UserExpectationsDTO;
import com.sbnz.RestaurantForYou.model.Restaurant;
import com.sbnz.RestaurantForYou.model.RestaurantRrequirements;
import com.sbnz.RestaurantForYou.repository.RestaurantRepository;

@Service
public class RestaurantService {

	private RestaurantRepository repository;
	private final KieContainer kieContainer;

	@Autowired
	public RestaurantService(RestaurantRepository repository, KieContainer kieContainer) {
		this.repository = repository;
		this.kieContainer = kieContainer;
	}

	public List<RestaurantDTO> recommandRestaurant(UserExpectationsDTO userExpectations) {

		// get the stateful session
		KieSession kieSession = kieContainer.newKieSession("rulesSession");

		RestaurantRrequirements restRequirments = new RestaurantRrequirements();
		kieSession.insert(userExpectations);
		kieSession.setGlobal("restRequirements", restRequirments);
		kieSession.getAgenda().getAgendaGroup("expectations").setFocus();
		kieSession.fireAllRules();

		List<Restaurant> restaurants = repository.findAll();
		for (Restaurant restaurant : restaurants) {
			kieSession.insert(restaurant);
		}
		kieSession.setGlobal("restRequirements", restRequirments);
		kieSession.getAgenda().getAgendaGroup("recommendation").setFocus();
		kieSession.fireAllRules();

		Comparator<Restaurant> compareByIRating = (Restaurant r1, Restaurant r2) -> Integer.compare(r1.getRating(),
				r2.getRating());
		Collections.sort(restaurants, compareByIRating.reversed());
		System.out.println(restRequirments);
		for (Restaurant restaurant : restaurants) {
			System.out.println(restaurant.getName() + " : " + restaurant.getRating());
		}
		return (restaurants.stream().map(restaurant -> {
			RestaurantDTO dto = RestaurantDTOConverter.convertToDTO(restaurant);
			return dto;
		})).collect(Collectors.toList());

	}

	public RestaurantDTO getRestaurant(Long id) {
		Optional<Restaurant> restaurant = repository.findById(id);
		return RestaurantDTOConverter.convertToDTO(restaurant.get());
	}

	public List<RestaurantDTO> getRestoraunts(Pageable pageable) {
		Page<Restaurant> restaurants = repository.findAll(pageable);
		return (restaurants.stream().map(restaurant -> {
			RestaurantDTO dto = RestaurantDTOConverter.convertToDTO(restaurant);
			dto.setSize(restaurants.getTotalElements());
			return dto;
		})).collect(Collectors.toList());
	}

	public boolean addNewRestaurant(RestaurantDTO dto) throws FileNotFoundException, IOException {
		// TO DO: provera validnosti radnog vremena
		Restaurant newRestaurant = RestaurantDTOConverter.convertFromDTO(dto);
		if (dto.getImage() != "") {
			byte[] imageByte = Base64.decode((dto.getImage().split(","))[1]);
			String directory = "/images";
			File f = new File(directory);
			f.mkdirs();
			try (FileOutputStream ff = new FileOutputStream(directory + "/" + dto.getName() + ".jpg")) {
				ff.write(imageByte);
			}
			newRestaurant.setImage("/images/" + dto.getName() + ".jpg");
		} else {
			newRestaurant.setImage("/images/" + "defaultTicketBackground" + ".jpg");
		}
		repository.save(newRestaurant);
		return true;
	}

}
