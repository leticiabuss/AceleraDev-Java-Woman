package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.challenge.entity.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findById(Long userId);
	@Query(value = "select * from acceleration ac\n" +
            "inner join candidate cd on cd.acceleration_id = ac.id\n" +
            "inner join users us on us.id = cd.user_id\n" +
            "where ac.name =:name", nativeQuery = true)
    List<User> findByAccelerationName(@Param("name")String name);

	 @Query( value = "select u.* from users u\n" +
	            "inner join candidate ca on ca.user_id = u.id\n" +
	            "inner join company c on c.id = ca.company_id where c.id = :companyId", nativeQuery = true)
    List<User> findByCompanyId(@Param("companyId") Long companyId);

}
