package com.sbnz.RestaurantForYou.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sbnz.RestaurantForYou.dto.RegistrationDTO;
import com.sbnz.RestaurantForYou.model.RegisteredUser;
import com.sbnz.RestaurantForYou.model.Role;

public class RegistrationDTOConverter {
	
	private static BCryptPasswordEncoder bc = new BCryptPasswordEncoder();

	public static RegisteredUser convertFromDTO(RegistrationDTO dto) {

		RegisteredUser user = new RegisteredUser();
		user.setUsername(dto.getUsername());
		user.setPassword(bc.encode(dto.getPassword()));
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setEmail(dto.getEmail());
		user.setRole(Role.ROLE_REGISTERED);
		return user;

	}

	public static RegistrationDTO convertToDTO(RegisteredUser user) {
		
		RegistrationDTO dto = new RegistrationDTO();
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setEmail(user.getEmail());
		dto.setUsername(user.getUsername());
		return dto;
	}
}
