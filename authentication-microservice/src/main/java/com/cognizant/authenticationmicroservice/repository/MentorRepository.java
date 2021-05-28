package com.cognizant.authenticationmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.authenticationmicroservice.model.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Integer> {
	@Query(value = "select * from mentor where username = :userName", nativeQuery = true)
	public Mentor findByName(@Param(value = "userName") String userName);
}
