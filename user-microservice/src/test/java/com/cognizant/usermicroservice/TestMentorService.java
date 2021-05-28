package com.cognizant.usermicroservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.usermicroservice.model.Mentor;
import com.cognizant.usermicroservice.model.MentorSkills;
import com.cognizant.usermicroservice.repository.MentorRepository;
import com.cognizant.usermicroservice.service.MentorService;

@SpringBootTest
public class TestMentorService {

	public TestMentorService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@InjectMocks
	MentorService mentorService;

	@Mock
	MentorRepository mentorRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@SuppressWarnings("deprecation")
	@Test
	@Transactional
	public void addMentorTest() {

		Mentor mentor = new Mentor();
		mentor.setId(1);
		mentor.setUsername("sauryaa");
		mentor.setPassword("$2a$10$9JH//xuAF9hRl9fsBQ/0r.I9IWZQZ0yG6xv.kx8g8iM6Z2.a1SpaK");
		mentor.setFirstName("Saurabh");
		mentor.setLastName("Asawa");
		mentor.setContactNumber("7410258963");
		mentor.setRegistrationDate(new Date(2019, 12, 03));
		mentor.setLinkedInUrl("abcd");
		mentor.setActive(true);

		when(mentorRepository.save(any(Mentor.class))).thenReturn(mentor);

		Mentor testMentor = new Mentor();

		testMentor = mentorRepository.save(mentor);
		// System.err.println(testMentor.toString());
		assertEquals(1, testMentor.getId());
		assertEquals("sauryaa", testMentor.getUserName());
		assertEquals("$2a$10$9JH//xuAF9hRl9fsBQ/0r.I9IWZQZ0yG6xv.kx8g8iM6Z2.a1SpaK", testMentor.getPassword());
		assertEquals("Saurabh", testMentor.getFirstName());
		assertEquals("Asawa", testMentor.getLastName());
		assertEquals("7410258963", testMentor.getContactNumber());
		assertEquals(new Date(2019, 12, 03), testMentor.getRegistrationDate());
		assertEquals("abcd", testMentor.getLinkedInUrl());
		assertEquals(true, testMentor.isActive());

	}

	@SuppressWarnings("deprecation")
	@Test
	@Transactional
	public void addMentorSkillTest() {

		Mentor mentor = new Mentor();
		mentor.setId(1);
		mentor.setUsername("sauryaa");
		mentor.setPassword("$2a$10$9JH//xuAF9hRl9fsBQ/0r.I9IWZQZ0yG6xv.kx8g8iM6Z2.a1SpaK");
		mentor.setFirstName("Saurabh");
		mentor.setLastName("Asawa");
		mentor.setContactNumber("7410258963");
		mentor.setRegistrationDate(new Date(2019, 12, 03));
		mentor.setLinkedInUrl("abcd");
		mentor.setActive(true);
		mentor.setMentorSkillList(null);

		MentorSkills mentorSkills = new MentorSkills();

		mentorSkills.setId(1);
		mentorSkills.setMentor(mentor);
		mentorSkills.setRatings(new BigDecimal(5));
		mentorSkills.setYearsOfExperience(new BigDecimal(5));
		System.err.println("mentor Skills: " + mentorSkills.toString());
		List<MentorSkills> mentorSkillList = new ArrayList<MentorSkills>();

		if (mentor.getMentorSkillList() != null)
			mentorSkillList = mentor.getMentorSkillList();
		System.err.println("mentor Skilllist: " + mentorSkillList.toString());
		mentorSkillList.add(mentorSkills);

		mentor.setMentorSkillList(mentorSkillList);

		when(mentorRepository.save(any(Mentor.class))).thenReturn(mentor);

		assertEquals(1, mentorSkills.getId());
		assertEquals(mentor, mentorSkills.getMentor());
		assertEquals(new BigDecimal(5), mentorSkills.getRatings());
		assertEquals(new BigDecimal(5), mentorSkills.getYearsOfExperience());

	}

}