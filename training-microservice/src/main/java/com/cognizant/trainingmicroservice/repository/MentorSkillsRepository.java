package com.cognizant.trainingmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.trainingmicroservice.model.MentorSkills;

public interface MentorSkillsRepository extends JpaRepository<MentorSkills, Integer> {
	@Query(value = "select m from MentorSkills m where m.mentor.id=:mentorId AND m.skill.id=:skillId")
	public MentorSkills findMentorSkills(@Param("mentorId") int mentorId, @Param("skillId") int skillId);

	// by venu
	@Query(value = "select m from MentorSkills m where m.mentor.id=:mentorId")
	public MentorSkills findMentorSkills(@Param("mentorId") int mentorId);
}
