package com.routemasterapi.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.routemasterapi.api.entity.UsersEntity;

@Repository
public interface UsersRepository extends CrudRepository<UsersEntity, Integer> {
	
	@Query(value = "SELECT count(*) FROM piyush_users", nativeQuery = true)
	String countNoOfUsers();
	
	@Query(value = "SELECT * FROM piyush_users", nativeQuery = true)
	Page<UsersEntity> listAllUsersFromDB(Pageable pageable);
}