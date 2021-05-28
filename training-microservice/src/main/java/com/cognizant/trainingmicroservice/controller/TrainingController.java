package com.cognizant.trainingmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.trainingmicroservice.ResponseTransfer;
import com.cognizant.trainingmicroservice.dto.MentorTrainingDTO;
import com.cognizant.trainingmicroservice.dto.ProposedTrainingsDTO;
import com.cognizant.trainingmicroservice.exception.EmptyListException;
import com.cognizant.trainingmicroservice.exception.TrainingAlreadyProposedException;
import com.cognizant.trainingmicroservice.service.TrainingService;

@RestController
@RequestMapping("/trainings")
@CrossOrigin("http://localhost:4200")
public class TrainingController {
	@Autowired
	private TrainingService trainingService;

	@GetMapping("user/{userName}/{status}/{progress}")
	public List<ProposedTrainingsDTO> getUserList(@PathVariable String userName, @PathVariable String status,
			@PathVariable String progress) throws EmptyListException {
		return trainingService.getUserList(userName, status, progress);
	}

	@GetMapping("mentor/{mentorName}/{status}/{progress}")
	public List<MentorTrainingDTO> getMentorList(@PathVariable String mentorName, @PathVariable String status,
			@PathVariable String progress) throws EmptyListException {
		return trainingService.getMentorList(mentorName, status, progress);
	}

	@PostMapping("user/propose/{userName}/{mentorName}/{skillName}")
	public ResponseTransfer proposeTraining(@PathVariable String userName, @PathVariable String mentorName,
			@PathVariable String skillName) throws TrainingAlreadyProposedException {
		return trainingService.proposeTraining(userName, mentorName, skillName);
	}

	@PutMapping("update/{userName}/{mentorName}/{skillName}/{status}")
	public ResponseTransfer updateTraining(@PathVariable String userName, @PathVariable String mentorName,
			@PathVariable String skillName, @PathVariable String status) {
		System.err.println("userName, mentorName, skillName, status" + userName + mentorName + skillName + status);
		return trainingService.updateTraining(userName, mentorName, skillName, status);
	}

	@PutMapping("user/{userName}/{mentorName}/{skillName}/{progress}/{rating}")
	public ResponseTransfer updateRatings(@PathVariable String userName, @PathVariable String mentorName,
			@PathVariable String skillName, @PathVariable String progress, @PathVariable float rating) {

		return trainingService.updateRatings(userName, mentorName, skillName, progress, rating);
	}

}
