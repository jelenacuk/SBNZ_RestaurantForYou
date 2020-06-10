package com.sbnz.RestaurantForYou.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.drools.template.ObjectDataCompiler;
import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.codec.Base64;
import com.sbnz.RestaurantForYou.converter.RestaurantDTOConverter;
import com.sbnz.RestaurantForYou.dto.ReportDTO;
import com.sbnz.RestaurantForYou.dto.RestaurantDTO;
import com.sbnz.RestaurantForYou.dto.UserExpectationsDTO;
import com.sbnz.RestaurantForYou.model.Restaurant;
import com.sbnz.RestaurantForYou.model.RestaurantRrequirements;
import com.sbnz.RestaurantForYou.repository.RestaurantRepository;
import com.sbnz.RestaurantForYou.template.RatingRange;

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
		
		KieSession kieSession =  getKieSession();
		
		// First apply rules to find restaurant features
		// Then apply rules for scoring each restaurant
		RestaurantRrequirements restRequirements = new RestaurantRrequirements();
		kieSession.insert(userExpectations);
		kieSession.insert(restRequirements);
		List<Restaurant> restaurants = repository.findAll();
		for (Restaurant restaurant : restaurants) {
			kieSession.insert(restaurant);
		}
		kieSession.fireAllRules();
		System.out.println(restRequirements);

		// Sorting restaurants by rating
		Comparator<Restaurant> compareByRating = (Restaurant r1, Restaurant r2) -> Integer.compare(r1.getScore(),
				r2.getScore());
		Collections.sort(restaurants, compareByRating.reversed());
		
		// Return first three restaurants
		if (restaurants.size() > 3) {
			restaurants = restaurants.subList(0, 3);
		}
		return (restaurants.stream().map(restaurant -> {
			RestaurantDTO dto = RestaurantDTOConverter.convertToDTO(restaurant, null);
			return dto;
		})).collect(Collectors.toList());
	}
	
	public List<RestaurantDTO> getRestaurantsByRatingRange(RatingRange ratingRange) {
		InputStream template = RestaurantService.class.getResourceAsStream("/templates/getRestaurantsByRatingRange.drt");
		ObjectDataCompiler converter = new ObjectDataCompiler();
		List<RatingRange> data = new ArrayList<RatingRange>();
		data.add(ratingRange);
		String drl = converter.compile(data, template);
		System.out.println("/n/n");
		System.out.println(drl);
		System.out.println("/n/n");
		KieSession kieSession = createKieSessionFromDRL(drl);
		List<Restaurant> result = new ArrayList<Restaurant>();
		for (Restaurant restaurant : repository.findAll()) {
			kieSession.insert(restaurant);
		}
		kieSession.setGlobal("result", result);
		kieSession.fireAllRules();
		return (result.stream().map(restaurant -> {
			RestaurantDTO dto = RestaurantDTOConverter.convertToDTO(restaurant, new ReportDTO(restaurant.getAverage(), 0));
			return dto;
		})).collect(Collectors.toList());
	}


	public RestaurantDTO getRestaurant(Long id) {
		KieSession kieSession =  getKieSession();
		Optional<Restaurant> restaurantOpt = repository.findById(101l);
		kieSession.insert(restaurantOpt.get());
		RestaurantDTO restDTO = null;
		kieSession.setGlobal("requirements", new RestaurantRrequirements());
		QueryResults results = kieSession.getQueryResults("User ratings", 101l);
		for (QueryResultsRow qrr : results) {
			Restaurant restaurant = (Restaurant) qrr.get("$restaurant");
			int reviewSum = (int) qrr.get("$reviewSum");
			long reviewNum = (long) qrr.get("$reviewNum");
			long ones = (long) qrr.get("$ones");
			long twos = (long) qrr.get("$twos");
			long threes = (long) qrr.get("$threes");
			long fours = (long) qrr.get("$fours");
			long fives = (long) qrr.get("$fives");
			double average = 0;
			if (restaurant.getResetaurantReviews().size() != 0) {
				average = reviewSum/restaurant.getResetaurantReviews().size();
			}
			ReportDTO reportDTO = new ReportDTO(average,reviewNum ,ones, twos, threes,
					fours, fives);
			restDTO = RestaurantDTOConverter.convertToDTO(restaurant, reportDTO);
		}
		return restDTO;
	}
	
	public List<RestaurantDTO> getRestoraunts(Pageable pageable) {
		
		KieSession kieSession = getKieSession();
		Page<Restaurant> restaurants = repository.findAll(pageable);
		for (Restaurant restaurant : restaurants) {
			kieSession.insert(restaurant);
		}
		kieSession.setGlobal("requirements", new RestaurantRrequirements());
		QueryResults results = kieSession.getQueryResults("Average rating");
		List<RestaurantDTO> returnList = new ArrayList<RestaurantDTO>();
		for(QueryResultsRow qrr : results) {
			Restaurant restaurant = (Restaurant) qrr.get("$restaurant");
			int reviewSum = (int) qrr.get("$reviewSum");
			long reviewNum = (long) qrr.get("$reviewNum");
			double average = 0;
			if (reviewNum != 0) {
				average = reviewSum / reviewNum;
			}
			ReportDTO reportDTO = new ReportDTO(average, reviewNum);
			RestaurantDTO restDTO = RestaurantDTOConverter.convertToDTO(restaurant, reportDTO);
			returnList.add(restDTO);
		}
		return returnList;
	}

	public boolean addNewRestaurant(RestaurantDTO dto) throws FileNotFoundException, IOException {
		
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
	
	private KieSession getKieSession() {
		KieServices ks = KieServices.Factory.get();
		KieBaseConfiguration kbconf = ks.newKieBaseConfiguration();
		kbconf.setOption(EventProcessingOption.STREAM);
		KieBase kbase = kieContainer.newKieBase(kbconf);
		KieSession kieSession = kbase.newKieSession();
		return kieSession;
	}
	
	private KieSession createKieSessionFromDRL(String drl){
        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(drl, ResourceType.DRL);
        
        Results results = kieHelper.verify();
        
        if (results.hasMessages(Message.Level.WARNING, Message.Level.ERROR)){
            List<Message> messages = results.getMessages(Message.Level.WARNING, Message.Level.ERROR);
            for (Message message : messages) {
                System.out.println("Error: "+message.getText());
            }
            
            throw new IllegalStateException("Compilation errors were found. Check the logs.");
        }
        
        return kieHelper.build().newKieSession();
    }
	

}
