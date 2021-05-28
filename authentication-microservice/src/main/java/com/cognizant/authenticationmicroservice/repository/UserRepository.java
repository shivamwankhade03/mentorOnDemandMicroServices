package com.cognizant.authenticationmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.authenticationmicroservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "select * from user where username = :userName", nativeQuery = true)
	public User findByName(@Param(value = "userName") String userName);

}
