package com.cognizant.searchmicroservice.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.searchmicroservice.exception.SkillNotFoundException;
import com.cognizant.searchmicroservice.model.Skills;
import com.cognizant.searchmicroservice.repository.SkillRepository;

@Service
public class SkillService {

	@Autowired
	private SkillRepository skillRepository;

	@Transactional
	public Skills findMentors(String skillName) throws SkillNotFoundException {
		Skills skills = skillRepository.findMentors(skillName);
		if (skills == null) {
			throw new SkillNotFoundException();
		} else {
			System.err.println(skills);
			return skills;
		}

	}
}
