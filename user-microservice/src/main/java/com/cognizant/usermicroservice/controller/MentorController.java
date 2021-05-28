package com.cognizant.usermicroservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.usermicroservice.ResponseTransfer;
import com.cognizant.usermicroservice.dto.MentorDTO;
import com.cognizant.usermicroservice.exception.MentorAlreadyExistsException;
import com.cognizant.usermicroservice.exception.MentorSkillAlreadyExistsException;
import com.cognizant.usermicroservice.model.Mentor;
import com.cognizant.usermicroservice.model.MentorSkills;
import com.cognizant.usermicroservice.service.MentorService;

@RestController
@RequestMapping("/mentor")
@CrossOrigin("http://localhost:4200")
public class MentorController {
	@Autowired
	private MentorService mentorService;

	@PostMapping("/addMentor")
	public ResponseTransfer addMentor(@RequestBody Mentor mentor) throws MentorAlreadyExistsException {
		return mentorService.addMentor(mentor);
	}

	@PutMapping("/addSkills/{mentorName}/{skillName}")
	public ResponseTransfer addSkill(@PathVariable String mentorName, @PathVariable String skillName,
			@RequestBody MentorSkills mentorSkill) throws MentorSkillAlreadyExistsException {
		mentorSkill.setRatings(new BigDecimal(0));
		mentorSkill.setTrainingsDeliverd(0);
		mentorSkill.setId(0);
		System.err.println("lolololoo" + mentorSkill);
		return mentorService.addSkill(mentorName, skillName, mentorSkill);
	}

	@GetMapping("/getMentor/{userName}")
	public MentorDTO getMentor(@PathVariable String userName) {
		System.err.println("tun pn ghe bolunnn");
		return mentorService.getMentor(userName);
	}

	@GetMapping("/profile/{mentorName}")
	public MentorDTO getMentorProfile(@PathVariable String mentorName) {
		Mentor mentor = mentorService.getMentorProfile(mentorName);
		MentorDTO mentorDTO = new MentorDTO(mentor.getId(), mentor.getUserName(), mentor.getPassword(),
				mentor.getFirstName(), mentor.getLastName(), mentor.getContactNumber(), mentor.getRegistrationDate(),
				mentor.getLinkedInUrl(), mentor.isActive());
		return mentorDTO;
	}

}
