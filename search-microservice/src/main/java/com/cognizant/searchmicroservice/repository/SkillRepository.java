package com.cognizant.searchmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.searchmicroservice.model.Skills;

@Repository
public interface SkillRepository extends JpaRepository<Skills, Integer> {

	@Query(value = "Select s from Skills s where s.name=:skillName")
	public Skills findMentors(@Param("skillName") String skillName);
}
