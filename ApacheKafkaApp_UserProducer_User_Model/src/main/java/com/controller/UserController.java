package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.User;
import com.service.UserProducerService;

@RestController
@RequestMapping("/userapi")
public class UserController {
	
	@Autowired
	private UserProducerService userProducerService;
	
	@PostMapping("/publishUserData")
	public void sendUserData(@RequestBody User user) {
		userProducerService.sendUserData(user);
	}

}
