package com.cognizant.authenticationmicroservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.authenticationmicroservice.dto.UserDto;
import com.cognizant.authenticationmicroservice.model.Mentor;
import com.cognizant.authenticationmicroservice.model.User;
import com.cognizant.authenticationmicroservice.repository.MentorRepository;
import com.cognizant.authenticationmicroservice.repository.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Override
	public String toString() {
		return "AppUserDetailsService [userRepository=" + userRepository + "]";
	}

	@Autowired
	UserRepository userRepository;

	@Autowired
	MentorRepository mentorRepository;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		try {

			UserDto userdto = new UserDto();
			String userName = name;
			name = name.substring(0, name.length() - 1);
			if (userName.endsWith("m")) {
				Mentor mentor = mentorRepository.findByName(name);
				userdto = new UserDto(mentor.getUserName(), mentor.getPassword(), "m");
				AppUser appUser = new AppUser(userdto);
				return appUser;
			} else if (userName.endsWith("u")) {
				User user = userRepository.findByName(name);
				userdto = new UserDto(user.getUserName(), user.getPassword(), "u");
				AppUser appUser = new AppUser(userdto);
				return appUser;
			}
			return null;

		} catch (Exception e) {
		}
		return null;
	}

}
