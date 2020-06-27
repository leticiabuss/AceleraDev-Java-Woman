package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.challenge.entity.Acceleration;

@RepositoryRestResource
public interface AccelerationRepository extends JpaRepository<Acceleration, Long>{

	Optional<Acceleration> findById(Long id);
	
	Optional<Acceleration> findByName(String name);

	List<Acceleration> findByCandidatesIdCompanyId( Long companyId );

}
