package com.cognizant.searchmicroservice.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "mentor")
public class Mentor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;

	@NotNull
	@Size(max = 45)
	@Column(name = "username")
	String username;

	@NotNull
	@Size(max = 200)
	@Column(name = "password")
	String password;

	@NotNull
	@Size(max = 45)
	@Column(name = "first_name")
	String firstName;

	@NotNull
	@Size(max = 45)
	@Column(name = "last_name")
	String lastName;

	@NotNull
	@Size(max = 10)
	@Column(name = "contact_number")
	String contactNumber;

	@NotNull
	@Column(name = "registration_date")
	Date registrationDate;

	@NotNull
	@Size(max = 50)
	@Column(name = "linkedin_url")
	String linkedInUrl;

	@NotNull
	@Column(name = "active")
	boolean active;

	// @OneToMany(mappedBy = "mentor")
	// List<MentorSkills> mentorSkillList;
	//
	public Mentor() {
		super();
	}

	public Mentor(@NotNull @Size(max = 11) int id, @NotNull @Size(max = 45) String username,
			@NotNull @Size(max = 200) String password, @NotNull @Size(max = 45) String firstName,
			@NotNull @Size(max = 45) String lastName, @NotNull @Size(max = 10) String contactNumber,
			@NotNull Date registrationDate, @NotNull @Size(max = 50) String linkedInUrl, @NotNull boolean active) {
		super();
		this.id = id;
		this.username = username;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	@Override
	public String toString() {
		return "Mentor [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", contactNumber=" + contactNumber + ", registrationDate="
				+ registrationDate + ", linkedInUrl=" + linkedInUrl + ", active=" + active + "]";
	}

	// public List<MentorSkills> getMentorSkillList() {
	// return mentorSkillList;
	// }
	//
	// public void setMentorSkillList(List<MentorSkills> mentorSkillList) {
	// this.mentorSkillList = mentorSkillList;
	// }

	// @Override
	// public String toString() {
	// return "Mentor [id=" + id + ", username=" + username + ", password=" +
	// password + ", firstName=" + firstName
	// + ", lastName=" + lastName + ", contactNumber=" + contactNumber + ",
	// registrationDate="
	// + registrationDate + ", linkedInUrl=" + linkedInUrl + ", active=" +
	// active + ", mentorSkillList="
	// + mentorSkillList + "]";
	// }

}
