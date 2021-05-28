package com.cognizant.trainingmicroservice;

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
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cognizant.trainingmicroservice.dto.MentorTrainingDTO;
import com.cognizant.trainingmicroservice.dto.ProposedTrainingsDTO;
import com.cognizant.trainingmicroservice.exception.EmptyListException;
import com.cognizant.trainingmicroservice.service.TrainingService;

public class TestTrainingService {

	public TestTrainingService() {
		super();
	}

	@Mock
	TrainingService trainingService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@Transactional
	public void testGetUserList() throws EmptyListException {
		
		 List<ProposedTrainingsDTO> proposedTrainingsDTOs = new ArrayList<>();
		 
		 ProposedTrainingsDTO proposedTrainingsDTO = new ProposedTrainingsDTO();
		 proposedTrainingsDTO.setSkillName("JAVA");
		 proposedTrainingsDTO.setEndDate(new Date(2019,02,02));
		 proposedTrainingsDTO.setFees(new BigDecimal(2000));
		 proposedTrainingsDTO.setMentorFirstName("Shubham");
		 proposedTrainingsDTO.setMentorLastName("Revanwar");
		 proposedTrainingsDTO.setMentorUserName("Shubham");
		 proposedTrainingsDTO.setProgressPercentage(22);
		 proposedTrainingsDTO.setRatings(new BigDecimal(2));
		 proposedTrainingsDTO.setYearsOfExperience(new BigDecimal(2));
		 proposedTrainingsDTO.setTrainingsDeliverd(56);
		 proposedTrainingsDTO.setStartDate(new Date(2019,02,01));
		 
		 proposedTrainingsDTOs.add(proposedTrainingsDTO);

		 when(trainingService.getUserList(any(String.class),any(String.class),any(String.class))).thenReturn(proposedTrainingsDTOs);
		
		 List<ProposedTrainingsDTO> testProposedTrainingsDTOs = new ArrayList<>();
		 testProposedTrainingsDTOs = trainingService.getUserList("User1","F","I");
	
		 assertEquals(proposedTrainingsDTOs, testProposedTrainingsDTOs);
 
	}
	
	@Test
	@Transactional
	public void testGetMentorList() throws EmptyListException {
		
		 List<MentorTrainingDTO> mentorTrainingDTOList = new ArrayList<>();
		 
		 MentorTrainingDTO mentorTrainingDTO = new MentorTrainingDTO();
		 
			mentorTrainingDTO.setUserName("User1");
			mentorTrainingDTO.setUserFirstName("Shubham");
			mentorTrainingDTO.setUserLastName("Revanwar");
			mentorTrainingDTO.setSkillName("JAVA");
			mentorTrainingDTO.setStartDate(new Date(2019, 06,06));
			mentorTrainingDTO.setEndDate(new Date(2019, 06,07));
		
			mentorTrainingDTOList.add(mentorTrainingDTO);
			
			when(trainingService.getMentorList(any(String.class),any(String.class),any(String.class))).thenReturn(mentorTrainingDTOList);
		 
			List<MentorTrainingDTO> testMentorTrainingDTOList = new ArrayList<>();
			testMentorTrainingDTOList = trainingService.getMentorList("Mentor1","F","I");
		
			assertEquals(mentorTrainingDTOList, testMentorTrainingDTOList);
	        
	}
}
	

