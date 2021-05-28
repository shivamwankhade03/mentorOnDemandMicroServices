package com.cognizant.trainingmicroservice.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "id")
	int id;

	@NotNull
	@Column(name = "username")
	String username;

	@NotNull
	@Column(name = "password")
	String password;

	@NotNull
	@Column(name = "first_name")
	String firstName;

	@NotNull
	@Column(name = "last_name")
	String lastName;

	@NotNull
	@Column(name = "contact_number")
	String contactNumber;

	@NotNull
	@Column(name = "registration_date")
	Date registrationDate;

	@NotNull
	@Column(name = "active")
	boolean active;

	public User() {
		super();
	}

	public User(@NotNull int id, @NotNull String username, @NotNull String password, @NotNull String firstName,
			@NotNull String lastName, @NotNull String contactNumber, @NotNull Date registrationDate,
			@NotNull boolean active) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.registrationDate = registrationDate;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", contactNumber=" + contactNumber + ", registrationDate="
				+ registrationDate + ", active=" + active + "]";
	}

}
