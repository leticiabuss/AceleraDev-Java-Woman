package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.challenge.entity.Challenge;

@RepositoryRestResource
public interface ChallengeRepository extends JpaRepository<Challenge, Long>{
	 @Query(value = "select distinct ch.id, ch.name, ch.slug, ch.created_at from challenge ch join "
	 		+ "(acceleration a join candidate ca on ca.user_id = :userId " + 
			 "and a.id = :accelerationId and ca.acceleration_id = a.id) on ch.id=a.challenge_id", nativeQuery = true)
	 List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId")Long accelerationId, @Param("userId")Long userId);
}
