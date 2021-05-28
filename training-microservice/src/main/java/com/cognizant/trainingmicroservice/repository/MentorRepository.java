package com.cognizant.trainingmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.trainingmicroservice.model.Mentor;

public interface MentorRepository extends JpaRepository<Mentor, Integer> {

	public Mentor findByUsername(String username);

}
