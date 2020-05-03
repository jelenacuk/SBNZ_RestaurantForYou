package com.sbnz.RestaurantForYou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.sbnz.RestaurantForYou.converter.RegistrationDTOConverter;
import com.sbnz.RestaurantForYou.dto.LoginDTO;
import com.sbnz.RestaurantForYou.dto.RegistrationDTO;
import com.sbnz.RestaurantForYou.model.RegisteredUser;
import com.sbnz.RestaurantForYou.model.User;
import com.sbnz.RestaurantForYou.repository.UserRepository;
import com.sbnz.RestaurantForYou.security.JwtToken;

@Service
public class UserService {

	private UserRepository repository;
	private AuthenticationManager authenticationManager;
	private JwtToken jwtTokenUtil;

	@Autowired
	public UserService(UserRepository userRepository, AuthenticationManager authenticationManager,
			JwtToken jwtTokenUtil) {
		this.repository = userRepository;
		this.authenticationManager = authenticationManager;
		this.jwtTokenUtil = jwtTokenUtil;
	}

	
	public String logIn(LoginDTO dto) {
		try {

			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));

		} catch (BadCredentialsException | InternalAuthenticationServiceException e) {

			e.printStackTrace();
		}
		final User user = repository.findOneByUsername(dto.getUsername());
		return jwtTokenUtil.generateToken(user.getUsername(), user.getRole().toString());
	}
	
	public RegisteredUser registrtion(RegistrationDTO dto) {
		// check if username is taken
		if (repository.findOneByUsername(dto.getUsername()) != null) {
			return null;
		}
		RegisteredUser newUser = RegistrationDTOConverter.convertFromDTO(dto);
		repository.save(newUser);
		return newUser;
	}
	

}
