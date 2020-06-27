package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.challenge.entity.Company;

@RepositoryRestResource
public interface CompanyRepository extends JpaRepository<Company, Long>{

	Optional<Company> findById(Long id);

	@Query(value = "select distinct co.id, co.name, co.slug, co.created_at from company co join (candidate ca join acceleration a on ca.acceleration_id = a.id " + 
			"and a.id = :accelerationId) on co.id = ca.company_id", nativeQuery = true)
    List<Company> findByAccelerationId(@Param("accelerationId") Long accelerationId);

	@Query(value = "select distinct co.id, co.name, co.slug, co.created_at from company co join candidate ca on ca.user_id = :userId and ca.company_id = co.id", nativeQuery = true)
	List<Company> findByUserId(@Param("userId") Long userId);
}
