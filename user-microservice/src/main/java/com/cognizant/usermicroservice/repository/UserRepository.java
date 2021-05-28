package com.cognizant.usermicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.usermicroservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserName(String userName);

}
