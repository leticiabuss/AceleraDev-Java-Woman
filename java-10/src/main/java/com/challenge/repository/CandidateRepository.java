package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;

@RepositoryRestResource
public interface CandidateRepository extends JpaRepository<Candidate, CandidateId>{
	
	Optional<Candidate> findCandidateById(CandidateId id);

    Optional<Candidate> findCandidateByIdUserIdAndIdCompanyIdAndIdAccelerationId(Long userId, Long companyId, Long accelerationId);

    List<Candidate> findByIdCompanyId(Long companyId);

    List<Candidate> findByIdAccelerationId(Long accelerationId);

}
