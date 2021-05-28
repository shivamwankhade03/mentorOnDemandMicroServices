package com.cognizant.usermicroservice.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.usermicroservice.ResponseTransfer;
import com.cognizant.usermicroservice.dto.MentorDTO;
import com.cognizant.usermicroservice.dto.MentorSkillsDTO;
import com.cognizant.usermicroservice.dto.SkillsDTO;
import com.cognizant.usermicroservice.exception.MentorAlreadyExistsException;
import com.cognizant.usermicroservice.exception.MentorSkillAlreadyExistsException;
import com.cognizant.usermicroservice.model.Mentor;
import com.cognizant.usermicroservice.model.MentorSkills;
import com.cognizant.usermicroservice.model.Skills;
import com.cognizant.usermicroservice.repository.MentorRepository;
import com.cognizant.usermicroservice.repository.SkillsRepository;

@Service
public class MentorService {
	@Autowired
	private MentorRepository mentorRepository;

	@Autowired
	private SkillsRepository skillsRepository;

	@Transactional
	public MentorDTO getMentor(String mentorName) {
		MentorDTO mentorDTO = getMentorDTO(mentorRepository.findByUserName(mentorName));
		// System.err.println(mentor);
		// System.err.println(mentor.getMentorSkillList());
		return mentorDTO;
	}

	public MentorDTO getMentorDTO(Mentor mentor) {

		List<MentorSkillsDTO> mentorSkillsDTOs = new ArrayList<>();
		for (MentorSkills m : mentor.getMentorSkillList()) {
			SkillsDTO skillsDTO = new SkillsDTO(m.getSkill().getId(), m.getSkill().getName(),
					m.getSkill().getDuration(), m.getSkill().getTableOfContents(), m.getSkill().getPrerequites());
			MentorSkillsDTO mentorSkillsDTO = new MentorSkillsDTO(m.getId(), m.getRatings(), m.getYearsOfExperience(),
					m.getTrainingsDeliverd(), m.getFees(), skillsDTO);
			mentorSkillsDTOs.add(mentorSkillsDTO);
		}
		MentorDTO mentorDTO = new MentorDTO(mentor.getId(), mentor.getUserName(), mentor.getPassword(),
				mentor.getFirstName(), mentor.getLastName(), mentor.getContactNumber(), mentor.getRegistrationDate(),
				mentor.getLinkedInUrl(), mentor.isActive(), mentorSkillsDTOs);
		return mentorDTO;
	}

	@Transactional
	public ResponseTransfer addMentor(Mentor mentor) throws MentorAlreadyExistsException {
		Mentor mentor1 = mentorRepository.findByUserName(mentor.getUserName());
		if (mentor1 != null) {
			throw new MentorAlreadyExistsException();
		} else {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			mentor.setPassword(bCryptPasswordEncoder.encode(mentor.getPassword()));
			mentorRepository.save(mentor);
			return new ResponseTransfer("Save successfully");
		}
	}

	@Transactional
	public ResponseTransfer addSkill(String mentorName, String skillName, MentorSkills mentorSkill)
			throws MentorSkillAlreadyExistsException {
		mentorSkill.setRatings(new BigDecimal(0));
		mentorSkill.setTrainingsDeliverd(0);
		mentorSkill.setId(0);
		Mentor mentor = mentorRepository.findByUserName(mentorName);
		Skills skills = skillsRepository.findByName(skillName);
		List<MentorSkills> mentorSkillList = mentor.getMentorSkillList();
		MentorSkills reMentorSkills = new MentorSkills();

		for (MentorSkills mentorSkills : mentorSkillList) {
			if (mentorSkills.getSkill().getName().equalsIgnoreCase(skills.getName())) {
				if (mentorSkills.getFees().floatValue() == (mentorSkill.getFees()).floatValue()) {
					throw new MentorSkillAlreadyExistsException();
				}
				reMentorSkills = mentorSkills;
				mentorSkill.setId(mentorSkills.getId());
				mentorSkill.setRatings(mentorSkills.getRatings());
			}
		}

		mentorSkillList.remove(reMentorSkills);
		mentorSkill.setMentor(mentor);
		mentorSkill.setSkill(skills);
		mentorSkillList.add(mentorSkill);
		mentor.setMentorSkillList(mentorSkillList);
		mentorRepository.save(mentor);
		return new ResponseTransfer("Skill set successfully");
	}

	@Transactional
	public Mentor getMentorProfile(String mentorName) {
		// TODO Auto-generated method stub
		Mentor mentor = mentorRepository.findByUserName(mentorName);
		System.err.println((mentor));
		return mentor;
	}

}
