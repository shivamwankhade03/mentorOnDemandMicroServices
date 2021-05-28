package com.cognizant.searchmicroservice.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "skills")
public class Skills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "id")
	int id;

	@NotNull
	@Column(name = "name")
	String name;

	@NotNull
	@Column(name = "duration")
	BigDecimal duration;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_skill_id")
	List<MentorSkills> mentorSkillList;

	public Skills() {
		super();
	}

	public Skills(@NotNull int id, @NotNull String name, @NotNull BigDecimal duration,
			List<MentorSkills> mentorSkillList) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.mentorSkillList = mentorSkillList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getDuration() {
		return duration;
	}

	public void setDuration(BigDecimal duration) {
		this.duration = duration;
	}

	public List<MentorSkills> getMentorSkillList() {
		return mentorSkillList;
	}

	public void setMentorSkillList(List<MentorSkills> mentorSkillList) {
		this.mentorSkillList = mentorSkillList;
	}

	@Override
	public String toString() {
		return "Skills [id=" + id + ", name=" + name + ", duration=" + duration + ", mentorSkillList=" + mentorSkillList
				+ "]";
	}

}
