package com.sbnz.RestaurantForYou.service;

import java.util.Date;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.sbnz.RestaurantForYou.converter.RegistrationDTOConverter;
import com.sbnz.RestaurantForYou.dto.LoginDTO;
import com.sbnz.RestaurantForYou.dto.RegistrationDTO;
import com.sbnz.RestaurantForYou.events.FailedLogInEvent;
import com.sbnz.RestaurantForYou.model.RegisteredUser;
import com.sbnz.RestaurantForYou.model.User;
import com.sbnz.RestaurantForYou.repository.UserRepository;
import com.sbnz.RestaurantForYou.security.JwtToken;

@Service
public class AuthenticationService {

	private UserRepository repository;
	private AuthenticationManager authenticationManager;
	private JwtToken jwtTokenUtil;
	private KnowledgeService knowledgeService;

	@Autowired
	public AuthenticationService(UserRepository userRepository, AuthenticationManager authenticationManager,
			JwtToken jwtTokenUtil, KnowledgeService knowledgeService) {
		this.repository = userRepository;
		this.authenticationManager = authenticationManager;
		this.jwtTokenUtil = jwtTokenUtil;
		this.knowledgeService = knowledgeService;
	}

	
	public String logIn(LoginDTO dto) {
		try {

			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));

		} catch (BadCredentialsException | InternalAuthenticationServiceException e) {
			User user = repository.findOneByUsername(dto.getUsername());
			if (user != null) {
				FailedLogInEvent event = new FailedLogInEvent(new Date(), user);
				KieSession kieSession = knowledgeService.getEventsSession();
				kieSession.insert(event);
				kieSession.fireAllRules();
			}
			throw new BadCredentialsException("Bad credentials.");
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
