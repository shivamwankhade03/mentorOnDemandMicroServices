package com.cognizant.usermicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.usermicroservice.ResponseTransfer;
import com.cognizant.usermicroservice.exception.UserAlreadyExistsException;
import com.cognizant.usermicroservice.model.User;
import com.cognizant.usermicroservice.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/addUser")
	public ResponseTransfer addUser(@RequestBody User user) throws UserAlreadyExistsException {
		return userService.addUser(user);
	}

}
