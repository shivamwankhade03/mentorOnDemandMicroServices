package com.cognizant.trainingmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.trainingmicroservice.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUsername(String username);
}
