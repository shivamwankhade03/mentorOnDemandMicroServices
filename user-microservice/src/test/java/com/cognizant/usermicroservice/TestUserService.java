package com.cognizant.usermicroservice;

import java.sql.Date;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import com.cognizant.usermicroservice.model.User;
import com.cognizant.usermicroservice.repository.UserRepository;
import com.cognizant.usermicroservice.service.UserService;

@SpringBootTest
public class TestUserService {

	
	public TestUserService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@InjectMocks
	UserService userService;

	@Mock
	UserRepository userRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@Transactional
	public void findUserByIdTest() {
		
		User user = new User();
		user.setId(1);
		user.setUserName("Aarthi");
		user.setPassword("$2a$10$9JH//xuAF9hRl9fsBQ/0r.I9IWZQZ0yG6xv.kx8g8iM6Z2.a1SpaK");
		user.setFirstName("Aarthi");
		user.setLastName("Moni");
		user.setContactNumber("8072859537");
		user.setRegistrationDate(new Date(2019, 12, 03));
		user.setActive(true);
		
		User user1 = new User();
		user1.setId(2);
		user1.setUserName("Aarthi");
		user1.setPassword("$2a$10$9JH//xuAF9hRl9fsBQ/0r.I9IWZQZ0yG6xv.kx8g8iM6Z2.a1SpaK");
		user1.setFirstName("Aarthi");
		user1.setLastName("Moni");
		user1.setContactNumber("8072859537");
		user1.setRegistrationDate(new Date(2019, 12, 03));
		user1.setActive(true);
		
		when(userRepository.save(any(User.class))).thenReturn(user);
		
		User testUser = new User();

		testUser =userRepository.save(user);
	//	System.err.println(testUser.toString());
		assertEquals(1, testUser.getId());
		assertEquals("Aarthi", testUser.getUserName());
		assertEquals("$2a$10$9JH//xuAF9hRl9fsBQ/0r.I9IWZQZ0yG6xv.kx8g8iM6Z2.a1SpaK", testUser.getPassword());
		assertEquals("Aarthi", testUser.getFirstName());
		assertEquals("Moni", testUser.getLastName());
		assertEquals("8072859537", testUser.getContactNumber());
		assertEquals(new Date(2019, 12, 03), testUser.getRegistrationDate());
		assertEquals(true, testUser.isActive());
		
	}
		
		
		
}