package com.cognizant.trainingmicroservice.dto;

import java.sql.Date;

public class MentorTrainingDTO {
	String userName;
	String userFirstName;
	String userLastName;
	String skillName;
	Date startDate;
	Date endDate;
	float progressPercentage;

	public MentorTrainingDTO() {
		super();
	}

	public MentorTrainingDTO(String userFirstName, String userLastName, String skillName, Date startDate, Date endDate,
			float progressPercentage) {
		super();
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.skillName = skillName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.progressPercentage = progressPercentage;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "MentorTrainingDTO [userName=" + userName + ", userFirstName=" + userFirstName + ", userLastName="
				+ userLastName + ", skillName=" + skillName + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", progressPercentage=" + progressPercentage + "]";
	}

}
