package com.cognizant.usermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.usermicroservice.model.MentorSkills;

public interface MentorSkillRepository extends JpaRepository<MentorSkills, Integer> {

}
