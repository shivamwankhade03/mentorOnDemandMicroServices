package com.cognizant.usermicroservice.dto;

import java.math.BigDecimal;

public class MentorSkillsDTO {
	private int id;
	private BigDecimal ratings;
	private BigDecimal yearsOfExperience;
	private int trainingsDeliverd;
	private BigDecimal fees;
	private MentorDTO mentorDTO;
	private SkillsDTO skillsDTO;

	public MentorSkillsDTO() {
		super();
	}

	public MentorSkillsDTO(int id, BigDecimal ratings, BigDecimal yearsOfExperience, int trainingsDeliverd,
			BigDecimal fees, SkillsDTO skillsDTO) {
		super();
		this.id = id;
		this.ratings = ratings;
		this.yearsOfExperience = yearsOfExperience;
		this.trainingsDeliverd = trainingsDeliverd;
		this.fees = fees;
		this.skillsDTO = skillsDTO;
	}

	public MentorSkillsDTO(int id, BigDecimal ratings, BigDecimal yearsOfExperience, int trainingsDeliverd,
			BigDecimal fees, MentorDTO mentorDTO, SkillsDTO skillsDTO) {
		super();
		this.id = id;
		this.ratings = ratings;
		this.yearsOfExperience = yearsOfExperience;
		this.trainingsDeliverd = trainingsDeliverd;
		this.fees = fees;
		this.mentorDTO = mentorDTO;
		this.skillsDTO = skillsDTO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getRatings() {
		return ratings;
	}

	public void setRatings(BigDecimal ratings) {
		this.ratings = ratings;
	}

	public BigDecimal getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(BigDecimal yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public int getTrainingsDeliverd() {
		return trainingsDeliverd;
	}

	public void setTrainingsDeliverd(int trainingsDeliverd) {
		this.trainingsDeliverd = trainingsDeliverd;
	}

	public BigDecimal getFees() {
		return fees;
	}

	public void setFees(BigDecimal fees) {
		this.fees = fees;
	}

	public MentorDTO getMentorDTO() {
		return mentorDTO;
	}

	public void setMentorDTO(MentorDTO mentorDTO) {
		this.mentorDTO = mentorDTO;
	}

	public SkillsDTO getSkillsDTO() {
		return skillsDTO;
	}

	public void setSkillsDTO(SkillsDTO skillsDTO) {
		this.skillsDTO = skillsDTO;
	}

	@Override
	public String toString() {
		return "MentorSkillsDTO [id=" + id + ", ratings=" + ratings + ", yearsOfExperience=" + yearsOfExperience
				+ ", trainingsDeliverd=" + trainingsDeliverd + ", fees=" + fees + ", mentorDTO=" + mentorDTO
				+ ", skillsDTO=" + skillsDTO + "]";
	}

}
