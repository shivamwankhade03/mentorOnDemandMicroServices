package com.cognizant.usermicroservice.dto;

import java.sql.Date;
import java.util.List;

public class MentorDTO {
	private int id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String contactNumber;
	private Date registrationDate;
	private String linkedInUrl;
	private boolean active;
	private List<MentorSkillsDTO> mentorSkillsDTOs;

	public MentorDTO() {
		super();
	}

	public MentorDTO(int id, String userName, String password, String firstName, String lastName, String contactNumber,
			Date registrationDate, String linkedInUrl, boolean active, List<MentorSkillsDTO> mentorSkillsDTOs) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.registrationDate = registrationDate;
		this.linkedInUrl = linkedInUrl;
		this.active = active;
		this.mentorSkillsDTOs = mentorSkillsDTOs;
	}

	public MentorDTO(int id, String userName, String password, String firstName, String lastName, String contactNumber,
			Date registrationDate, String linkedInUrl, boolean active) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.registrationDate = registrationDate;
		this.linkedInUrl = linkedInUrl;
		this.active = active;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getLinkedInUrl() {
		return linkedInUrl;
	}

	public void setLinkedInUrl(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<MentorSkillsDTO> getMentorSkillsDTOs() {
		return mentorSkillsDTOs;
	}

	public void setMentorSkillsDTOs(List<MentorSkillsDTO> mentorSkillsDTOs) {
		this.mentorSkillsDTOs = mentorSkillsDTOs;
	}

	@Override
	public String toString() {
		return "MentorDTO [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", contactNumber=" + contactNumber + ", registrationDate="
				+ registrationDate + ", linkedInUrl=" + linkedInUrl + ", active=" + active + ", mentorSkillsDTOs="
				+ mentorSkillsDTOs + "]";
	}

}
