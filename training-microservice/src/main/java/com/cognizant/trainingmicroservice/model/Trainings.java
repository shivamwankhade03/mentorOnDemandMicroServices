package com.cognizant.trainingmicroservice.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "trainings")
public class Trainings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;

	@NotNull
	@Size(max = 2)
	@Column(name = "status")
	String status;

	@NotNull
	@Column(name = "progress")
	String progress;

	@Column(name = "ratings")
	BigDecimal ratings;

	@Column(name = "start_date")
	Date startDate;

	@Column(name = "end_date")
	Date endDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_training_mentor_id", referencedColumnName = "id")
	Mentor mentor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_training_user_id", referencedColumnName = "id")
	User user;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_training_skill_id", referencedColumnName = "id")
	Skills skill;

	public Trainings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trainings(@NotNull @Size(max = 20) int id, @NotNull @Size(max = 2) String status, @NotNull String progress,
			@NotNull BigDecimal ratings, @NotNull Date startDate, @NotNull Date endDate, Mentor mentor, User user,
			Skills skill) {
		super();
		this.id = id;
		this.status = status;
		this.progress = progress;
		this.ratings = ratings;
		this.startDate = startDate;
		this.endDate = endDate;
		this.mentor = mentor;
		this.user = user;
		this.skill = skill;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public BigDecimal getRatings() {
		return ratings;
	}

	public void setRatings(BigDecimal ratings) {
		this.ratings = ratings;
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

	public Mentor getMentor() {
		return mentor;
	}

	public void setMentor(Mentor mentor) {
		this.mentor = mentor;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Skills getSkill() {
		return skill;
	}

	public void setSkill(Skills skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "Trainings [id=" + id + ", status=" + status + ", progress=" + progress + ", ratings=" + ratings
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", mentor=" + mentor + ", user=" + user
				+ ", skill=" + skill + "]";
	}

}
