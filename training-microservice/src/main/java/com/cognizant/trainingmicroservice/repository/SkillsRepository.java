package com.cognizant.trainingmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.trainingmicroservice.model.Skills;

public interface SkillsRepository extends JpaRepository<Skills, Integer> {

	public Skills findByName(String name);
}
