package com.challenge.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.challenge.entity.Submission;

@RepositoryRestResource
public interface SubmissionRepository extends JpaRepository<Submission, Long>{
	 
	@Query(value = "select max(s.score) from Submission s\n" +
            "inner join Challenge c on c.id = s.id.challenge where c.id = :challengeId")
	BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);

	@Query(value = "select * from submission s\n" +
            "inner join challenge c on c.id = s.challenge_id \n" +
            "inner join acceleration a on a.challenge_id = c.id\n" +
            "where c.id = :challengeId and a.id = :accelerationId", nativeQuery = true)
	List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId")Long challengeId, @Param("accelerationId")Long accelerationId);

}
