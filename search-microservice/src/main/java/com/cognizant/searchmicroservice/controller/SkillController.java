package com.cognizant.searchmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.searchmicroservice.exception.SkillNotFoundException;
import com.cognizant.searchmicroservice.model.Skills;
import com.cognizant.searchmicroservice.service.SkillService;

@RestController
@RequestMapping("/skills")
@CrossOrigin("http://localhost:4200")
public class SkillController {
	@Autowired
	private SkillService skillService;

	@GetMapping("/{skillName}")
	public Skills getMentors(@PathVariable String skillName) throws SkillNotFoundException {
		return skillService.findMentors(skillName);
	}
}
