package com.sbnz.RestaurantForYou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.RestaurantForYou.dto.LoginDTO;
import com.sbnz.RestaurantForYou.dto.RegistrationDTO;
import com.sbnz.RestaurantForYou.dto.TokenDTO;
import com.sbnz.RestaurantForYou.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(value = "/login")
	public  ResponseEntity<TokenDTO> logIn( @RequestBody LoginDTO dto ) {
		String token = userService.logIn(dto);
		return new ResponseEntity<TokenDTO>(new TokenDTO(token), HttpStatus.OK);
	}
	
	@PostMapping(value = "/registration")
	public ResponseEntity<Boolean> register (@RequestBody RegistrationDTO dto){
		if (userService.registrtion(dto) == null) {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
}
