package com.cognizant.trainingmicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.trainingmicroservice.model.Trainings;

@Repository
public interface TrainingRepository extends JpaRepository<Trainings, Integer> {

	@Query(value = "select t from Trainings t where t.status=:status AND t.progress=:progress AND t.user.id=:id")
	public List<Trainings> getUserList(@Param("id") int id, @Param("status") String status,
			@Param("progress") String progress);

	@Query(value = "select t from Trainings t where t.mentor.id=:id AND t.status=:status AND t.progress=:progress")
	public List<Trainings> getMentorList(@Param("id") int id, @Param("status") String status,
			@Param("progress") String progress);

	@Query(value = "select t from Trainings t where t.mentor.id=:mentorId AND t.user.id=:userId AND t.skill.id=:skillId")
	public Trainings getTraining(@Param("userId") int userId, @Param("mentorId") int mentorId,
			@Param("skillId") int skillId);

}
