package com.cognizant.usermicroservice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "mentor_skills")
public class MentorSkills {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;

	@NotNull
	@Column(name = "ratings")
	BigDecimal ratings;

	@NotNull
	@Column(name = "years_of_experience")
	BigDecimal yearsOfExperience;

	@NotNull
	@Column(name = "trainings_delivered")
	int trainingsDeliverd;

	@NotNull
	@Column(name = "course_fees")
	BigDecimal fees;

	@ManyToOne
	@JoinColumn(name = "fk_mentor_id", referencedColumnName = "id")
	Mentor mentor;

	@ManyToOne()
	@JoinColumn(name = "fk_skill_id", referencedColumnName = "id")
	Skills skill;

	public MentorSkills() {
		super();
	}

	public MentorSkills(@NotNull BigDecimal yearsOfExperience, @NotNull BigDecimal fees) {
		super();

		this.yearsOfExperience = yearsOfExperience;
		this.fees = fees;

	}

	public MentorSkills(int id, @NotNull BigDecimal ratings, @NotNull BigDecimal yearsOfExperience,
			@NotNull int trainingsDeliverd, @NotNull BigDecimal fees) {
		super();
		this.id = id;
		this.ratings = ratings;
		this.yearsOfExperience = yearsOfExperience;
		this.trainingsDeliverd = trainingsDeliverd;
		this.fees = fees;
	}

	public MentorSkills(int id, @NotNull BigDecimal ratings, @NotNull BigDecimal yearsOfExperience,
			@NotNull int trainingsDeliverd, @NotNull BigDecimal fees, Skills skill) {
		super();
		this.id = id;
		this.ratings = ratings;
		this.yearsOfExperience = yearsOfExperience;
		this.trainingsDeliverd = trainingsDeliverd;
		this.fees = fees;
		this.skill = skill;
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

	public Mentor getMentor() {
		return mentor;
	}

	public void setMentor(Mentor mentor) {
		this.mentor = mentor;
	}

	public BigDecimal getFees() {
		return fees;
	}

	public void setFees(BigDecimal fees) {
		this.fees = fees;
	}

	public Skills getSkill() {
		return skill;
	}

	public void setSkill(Skills skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "MentorSkills [id=" + id + ", ratings=" + ratings + ", yearsOfExperience=" + yearsOfExperience
				+ ", trainingsDeliverd=" + trainingsDeliverd + ", fees=" + fees + ", mentor=" + mentor + ", skill="
				+ skill + "]";
	}

	// @Override
	// public String toString() {
	// return "MentorSkills [id=" + id + ", ratings=" + ratings + ",
	// yearsOfExperience=" + yearsOfExperience
	// + ", trainingsDeliverd=" + trainingsDeliverd + ", fees=" + fees + "]";
	// }

}
