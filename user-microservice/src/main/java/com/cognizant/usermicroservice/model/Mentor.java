package com.cognizant.usermicroservice.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	String userName;

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

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "mentor", cascade = CascadeType.ALL)
	List<MentorSkills> mentorSkillList;

	public Mentor() {
		super();
	}

	// id=1, username=t1,
	// password=$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK,
	// firstName=t1, lastName=t1, contactNumber=0123456789,
	// registrationDate=2019-11-10, linkedInUrl=xmhbfjsvbf, active=true]
	public Mentor(@NotNull int id, @NotNull @Size(max = 45) String userName, @NotNull @Size(max = 200) String password,
			@NotNull @Size(max = 45) String firstName, @NotNull @Size(max = 45) String lastName,
			@NotNull @Size(max = 10) String contactNumber, @NotNull Date registrationDate,
			@NotNull @Size(max = 50) String linkedInUrl, @NotNull boolean active) {
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

	// public Mentor(@NotNull @Size(max = 11) int id, @NotNull @Size(max = 45)
	// String userName,
	// @NotNull @Size(max = 200) String password, @NotNull @Size(max = 45)
	// String firstName,
	// @NotNull @Size(max = 45) String lastName, @NotNull @Size(max = 10) String
	// contactNumber,
	// @NotNull Date registrationDate, @NotNull @Size(max = 50) String
	// linkedInUrl, @NotNull boolean active,
	// List<MentorSkills> mentorSkillList) {
	// super();
	// this.id = id;
	// this.userName = userName;
	// this.password = password;
	// this.firstName = firstName;
	// this.lastName = lastName;
	// this.contactNumber = contactNumber;
	// this.registrationDate = registrationDate;
	// this.linkedInUrl = linkedInUrl;
	// this.active = active;
	// this.mentorSkillList = mentorSkillList;
	// }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUsername(String userName) {
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

	public List<MentorSkills> getMentorSkillList() {
		return mentorSkillList;
	}

	public void setMentorSkillList(List<MentorSkills> mentorSkillList) {
		this.mentorSkillList = mentorSkillList;
	}

	@Override
	public String toString() {
		return "Mentor [id=" + id + ", username=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", contactNumber=" + contactNumber + ", registrationDate="
				+ registrationDate + ", linkedInUrl=" + linkedInUrl + ", active=" + active + "]";
	}

}
