package com.cognizant.trainingmicroservice.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class ProposedTrainingsDTO {
	String mentorUserName;
	String skillName;
	BigDecimal ratings;
	BigDecimal yearsOfExperience;
	int trainingsDeliverd;
	BigDecimal fees;
	String mentorFirstName;
	String mentorLastName;
	Date startDate;
	Date endDate;
	float progressPercentage;

	public ProposedTrainingsDTO() {
		super();
	}

	public ProposedTrainingsDTO(String skillName, BigDecimal ratings, BigDecimal yearsOfExperience,
			int trainingsDeliverd, BigDecimal fees, String mentorFirstName, String mentorLastName) {
		super();
		this.skillName = skillName;
		this.ratings = ratings;
		this.yearsOfExperience = yearsOfExperience;
		this.trainingsDeliverd = trainingsDeliverd;
		this.fees = fees;
		this.mentorFirstName = mentorFirstName;
		this.mentorLastName = mentorLastName;
	}

	public ProposedTrainingsDTO(String skillName, BigDecimal ratings, BigDecimal yearsOfExperience,
			int trainingsDeliverd, BigDecimal fees, String mentorFirstName, String mentorLastName, Date startDate,
			Date endDate) {
		super();
		this.skillName = skillName;
		this.ratings = ratings;
		this.yearsOfExperience = yearsOfExperience;
		this.trainingsDeliverd = trainingsDeliverd;
		this.fees = fees;
		this.mentorFirstName = mentorFirstName;
		this.mentorLastName = mentorLastName;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public ProposedTrainingsDTO(String skillName, BigDecimal ratings, BigDecimal yearsOfExperience,
			int trainingsDeliverd, BigDecimal fees, String mentorFirstName, String mentorLastName, Date startDate,
			Date endDate, float progressPercentage) {
		super();
		this.skillName = skillName;
		this.ratings = ratings;
		this.yearsOfExperience = yearsOfExperience;
		this.trainingsDeliverd = trainingsDeliverd;
		this.fees = fees;
		this.mentorFirstName = mentorFirstName;
		this.mentorLastName = mentorLastName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.progressPercentage = progressPercentage;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
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

	public String getMentorFirstName() {
		return mentorFirstName;
	}

	public void setMentorFirstName(String mentorFirstName) {
		this.mentorFirstName = mentorFirstName;
	}

	public String getMentorLastName() {
		return mentorLastName;
	}

	public void setMentorLastName(String mentorLastName) {
		this.mentorLastName = mentorLastName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public float getProgressPercentage() {
		return progressPercentage;
	}

	public void setProgressPercentage(float progressPercentage) {
		this.progressPercentage = progressPercentage;
	}

	public String getMentorUserName() {
		return mentorUserName;
	}

	public void setMentorUserName(String mentorUserName) {
		this.mentorUserName = mentorUserName;
	}

	@Override
	public String toString() {
		return "ProposedTrainingsDTO [mentorUserName=" + mentorUserName + ", skillName=" + skillName + ", ratings="
				+ ratings + ", yearsOfExperience=" + yearsOfExperience + ", trainingsDeliverd=" + trainingsDeliverd
				+ ", fees=" + fees + ", mentorFirstName=" + mentorFirstName + ", mentorLastName=" + mentorLastName
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", progressPercentage=" + progressPercentage
				+ "]";
	}

}
