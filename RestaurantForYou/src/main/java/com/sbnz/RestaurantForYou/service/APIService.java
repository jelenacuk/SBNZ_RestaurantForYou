package com.sbnz.RestaurantForYou.service;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.sbnz.RestaurantForYou.converter.RestaurantSetter;
import com.sbnz.RestaurantForYou.dto.api.ApiResponseDTO;
import com.sbnz.RestaurantForYou.dto.api.RestaurantDataDto;
import com.sbnz.RestaurantForYou.model.ApiAccount;
import com.sbnz.RestaurantForYou.model.Restaurant;
import com.sbnz.RestaurantForYou.repository.ApiAccountRepository;
import com.sbnz.RestaurantForYou.repository.ContactInfoRepository;
import com.sbnz.RestaurantForYou.repository.LocationRepository;
import com.sbnz.RestaurantForYou.repository.RestaurantRepository;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

@Service
public class APIService {
	
	private ApiAccountRepository apiRepository;
	private RestaurantRepository restaurantRepository;
	private ContactInfoRepository contactInfoRepository;
	private LocationRepository locationRepository;
	
	private final String url = "https://tripadvisor1.p.rapidapi.com/restaurants/list?restaurant_tagcategory_standalone=10591&lunit=km&restaurant_tagcategory=10591&limit=30&lang=en_US&location_id=294472";
	

	public APIService(RestaurantRepository restaurantRepository, ContactInfoRepository contactInfoRepository,
			LocationRepository locationRepository, ApiAccountRepository apiRepository) {
		this.apiRepository = apiRepository;
		this.restaurantRepository = restaurantRepository;
		this.contactInfoRepository = contactInfoRepository;
		this.locationRepository = locationRepository;
	}
	
	@PostConstruct
	public void getRestaurants() {
		
		ApiAccount account = getAccount();
		if (account != null) {
			HttpResponse<String> respone = Unirest.get(url)
					.header("x-rapidapi-host", account.getHost())
					.header("x-rapidapi-key", account.getHostKey())
					.asString();
			account.setCounter(account.getCounter() + 1);
			apiRepository.save(account);
			Gson gson = new Gson();
			ApiResponseDTO result = gson.fromJson(respone.getBody(), ApiResponseDTO.class);
			System.out.println("UKUPNO -> " +  result.getData().size());
			for (RestaurantDataDto dto: result.getData()) {
				Restaurant restaurant = restaurantRepository.findOneByName(dto.getName());
				if (restaurant != null) {
					RestaurantSetter.restaurantSettter(restaurant, dto);
					contactInfoRepository.save(restaurant.getContact());
					locationRepository.save(restaurant.getLocation());
				}else {
					restaurant = new Restaurant();
					RestaurantSetter.restaurantSettter(restaurant, dto);
				}
				if (restaurant.getFeatures() == null) {
					restaurant.setCompleted(false);
					restaurant.setAverage(0.0);
				}
				else {
					restaurant.setCompleted(true);
				}
				restaurantRepository.save(restaurant);
			}	
		}	
	}
	
	private ApiAccount getAccount() {
		List<ApiAccount> accounts = apiRepository.findAll();
		ApiAccount freeAccount = null;
		for (ApiAccount apiAccount : accounts) {
			if (apiAccount.getDate().isBefore(LocalDate.now().minusMonths(1))) {
				apiAccount.setDate(LocalDate.now());
				apiAccount.setCounter(0);
			}
			if (apiAccount.getCounter() < 500 ) {
				freeAccount = apiAccount;
				break;
			}
		}
		apiRepository.saveAll(accounts);
		return freeAccount;
	}
}
