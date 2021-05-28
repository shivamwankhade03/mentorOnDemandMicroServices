package com.cognizant.trainingmicroservice.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.trainingmicroservice.ResponseTransfer;
import com.cognizant.trainingmicroservice.dto.MentorTrainingDTO;
import com.cognizant.trainingmicroservice.dto.ProposedTrainingsDTO;
import com.cognizant.trainingmicroservice.exception.EmptyListException;
import com.cognizant.trainingmicroservice.exception.TrainingAlreadyProposedException;
import com.cognizant.trainingmicroservice.model.Mentor;
import com.cognizant.trainingmicroservice.model.MentorSkills;
import com.cognizant.trainingmicroservice.model.Skills;
import com.cognizant.trainingmicroservice.model.Trainings;
import com.cognizant.trainingmicroservice.model.User;
import com.cognizant.trainingmicroservice.repository.MentorRepository;
import com.cognizant.trainingmicroservice.repository.MentorSkillsRepository;
import com.cognizant.trainingmicroservice.repository.SkillsRepository;
import com.cognizant.trainingmicroservice.repository.TrainingRepository;
import com.cognizant.trainingmicroservice.repository.UserRepository;

@Service
public class TrainingService {

	@Autowired
	private TrainingRepository trainingRepository;

	@Autowired
	private MentorSkillsRepository mentorSkillsRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MentorRepository mentorRepository;

	@Autowired
	private SkillsRepository skillsRepository;

	@Transactional
	public List<ProposedTrainingsDTO> getUserList(String userName, String status, String progress)
			throws EmptyListException {
		User user = userRepository.findByUsername(userName);
		List<Trainings> trainings = trainingRepository.getUserList(user.getId(), status, progress);
		if (trainings.isEmpty()) {
			throw new EmptyListException();
		}

		List<ProposedTrainingsDTO> proposedTrainingsDTOs = new ArrayList<>();
		for (Trainings training : trainings) {

			MentorSkills mentorSkill = mentorSkillsRepository.findMentorSkills(training.getMentor().getId(),
					training.getSkill().getId());
			ProposedTrainingsDTO proposedTrainingsDTO = new ProposedTrainingsDTO();
			proposedTrainingsDTO.setMentorUserName(training.getMentor().getUsername());

			proposedTrainingsDTO.setMentorFirstName(training.getMentor().getFirstName());
			proposedTrainingsDTO.setMentorLastName(training.getMentor().getLastName());
			proposedTrainingsDTO.setSkillName(training.getSkill().getName());

			proposedTrainingsDTO.setFees(mentorSkill.getFees());

			if (status.equalsIgnoreCase("F")) {
				proposedTrainingsDTO.setRatings(training.getRatings());
				proposedTrainingsDTO.setStartDate(training.getStartDate());
				proposedTrainingsDTO.setEndDate(training.getEndDate());

				long currentDateTime = System.currentTimeMillis();
				Date startDate = training.getStartDate();
				Date endDate = training.getEndDate();
				long dateDifference = currentDateTime - startDate.getTime();

				long wholeDuration = endDate.getTime() - startDate.getTime();

				float progressPercentage = (dateDifference * 100 / wholeDuration);

				System.err.println("dateDifference*100/wholeDuration: " + dateDifference / wholeDuration);
				proposedTrainingsDTO.setProgressPercentage(progressPercentage);

			} else {
				proposedTrainingsDTO.setYearsOfExperience(mentorSkill.getYearsOfExperience());
				proposedTrainingsDTO.setTrainingsDeliverd(mentorSkill.getTrainingsDeliverd());
				proposedTrainingsDTO.setRatings(mentorSkill.getRatings());
			}
			proposedTrainingsDTOs.add(proposedTrainingsDTO);
		}

		return proposedTrainingsDTOs;
	}

	@Transactional
	public List<MentorTrainingDTO> getMentorList(String mentorName, String status, String progress)
			throws EmptyListException {
		Mentor mentor = mentorRepository.findByUsername(mentorName);
		List<Trainings> trainings = trainingRepository.getMentorList(mentor.getId(), status, progress);

		if (trainings.isEmpty()) {
			throw new EmptyListException();
		}
		List<MentorTrainingDTO> mentorTrainingDTOs = new ArrayList<>();

		for (Trainings training : trainings) {
			MentorTrainingDTO mentorTrainingDTO = new MentorTrainingDTO();
			mentorTrainingDTO.setUserFirstName(training.getUser().getFirstName());
			mentorTrainingDTO.setUserLastName(training.getUser().getLastName());
			mentorTrainingDTO.setUserName(training.getUser().getUsername());

			mentorTrainingDTO.setSkillName(training.getSkill().getName());

			mentorTrainingDTO.setStartDate(training.getStartDate());
			mentorTrainingDTO.setEndDate(training.getEndDate());

			mentorTrainingDTOs.add(mentorTrainingDTO);
		}

		return mentorTrainingDTOs;
	}

	@Transactional
	public ResponseTransfer proposeTraining(String userName, String mentorName, String skillName)
			throws TrainingAlreadyProposedException {
		Mentor mentor = mentorRepository.findByUsername(mentorName);
		User user = userRepository.findByUsername(userName);
		Skills skills = skillsRepository.findByName(skillName);

		Trainings trainings1 = trainingRepository.getTraining(user.getId(), mentor.getId(), skills.getId());
		if (trainings1 != null
				&& ((trainings1.getStatus().equalsIgnoreCase("P")) || (trainings1.getStatus().equalsIgnoreCase("A")))) {
			throw new TrainingAlreadyProposedException();
		}

		Trainings trainings = new Trainings(0, "P", "N", new BigDecimal(0), null, null, mentor, user, skills);

		trainingRepository.save(trainings);
		return new ResponseTransfer("Training proposted successfully");
	}

	@Transactional
	public ResponseTransfer updateTraining(String username, String mentorName, String skillName, String status) {
		User user = userRepository.findByUsername(username);
		Mentor mentor = mentorRepository.findByUsername(mentorName);
		Skills skills = skillsRepository.findByName(skillName);
		Trainings trainings = trainingRepository.getTraining(user.getId(), mentor.getId(), skills.getId());
		trainings.setStatus(status);

		if (status.equalsIgnoreCase("F")) {

			trainings.setProgress("I");
			long currentDateTime = System.currentTimeMillis();
			Date startDate = new Date(currentDateTime);
			trainings.setStartDate(startDate);
			BigDecimal duration = trainings.getSkill().getDuration();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			// Setting the date to the given date
			c.setTime(startDate);

			// Number of Days to add
			c.add(Calendar.DAY_OF_MONTH, duration.intValue());
			// Date after adding the days to the given date
			String newDate = sdf.format(c.getTime());
			trainings.setEndDate(Date.valueOf(newDate));

		}
		trainingRepository.save(trainings);
		return new ResponseTransfer("Training updated Successfully");
	}

	@Transactional
	public ResponseTransfer updateRatings(String username, String mentorName, String skillName, String progress,
			float rating) {
		User user = userRepository.findByUsername(username);
		Mentor mentor = mentorRepository.findByUsername(mentorName);
		Skills skills = skillsRepository.findByName(skillName);
		Trainings trainings = trainingRepository.getTraining(user.getId(), mentor.getId(), skills.getId());
		trainings.setRatings(new BigDecimal(rating));
		if (progress.equalsIgnoreCase("C")) {
			MentorSkills mentorSkill = mentorSkillsRepository.findMentorSkills(mentor.getId(), skills.getId());
			float previousAverageRating = mentorSkill.getRatings().floatValue();
			float noOfTrainingsDeliverd = mentorSkill.getTrainingsDeliverd();

			float averageRating = ((previousAverageRating * noOfTrainingsDeliverd) + rating)
					/ (mentorSkill.getTrainingsDeliverd() + 1);

			mentorSkill.setRatings(new BigDecimal(averageRating));
			mentorSkillsRepository.save(mentorSkill);
		}
		return new ResponseTransfer("Ratings updated Successfully");
	}
}
