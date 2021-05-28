package com.cognizant.searchmicroservice;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.searchmicroservice.model.Skills;
import com.cognizant.searchmicroservice.repository.SkillRepository;
import com.cognizant.searchmicroservice.service.SkillService;

public class TestSearchService {

	@Mock
	SkillRepository skillRepository;
	
	@InjectMocks
	SkillService skillService;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	public TestSearchService() {
		super();
	}

	@Test
	@Transactional
	public void testFindMentors() {
		
		Skills skills = new Skills();
		
		skills.setId(1);
		skills.setName("Angular");
		skills.setDuration(new BigDecimal(2));
		
		when(skillRepository.findMentors(skills.getName())).thenReturn(skills);
		
		Skills testSkills = new Skills();
		testSkills = skillRepository.findMentors(skills.getName());
		
		assertEquals(skills, testSkills);
		
	}
	
	
}
