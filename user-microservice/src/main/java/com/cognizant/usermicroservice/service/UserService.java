package com.cognizant.usermicroservice.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.usermicroservice.ResponseTransfer;
import com.cognizant.usermicroservice.exception.UserAlreadyExistsException;
import com.cognizant.usermicroservice.model.User;
import com.cognizant.usermicroservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public ResponseTransfer addUser(User user) throws UserAlreadyExistsException {
		User user1 = userRepository.findByUserName(user.getUserName());
		if (user1 != null) {
			throw new UserAlreadyExistsException();
		} else {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			return new ResponseTransfer("Save successfully");
		}
	}

}
