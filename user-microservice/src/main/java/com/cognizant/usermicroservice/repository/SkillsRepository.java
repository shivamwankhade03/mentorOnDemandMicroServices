package com.cognizant.usermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.usermicroservice.model.Skills;

public interface SkillsRepository extends JpaRepository<Skills, Integer> {
	public Skills findByName(String name);
}
