package com.cognizant.usermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.usermicroservice.model.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Integer> {

	public Mentor findByUserName(String userName);
}
