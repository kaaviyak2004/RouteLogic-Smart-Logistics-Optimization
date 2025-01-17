package com.routemasterapi.api.repositories;

import java.math.BigInteger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.routemasterapi.api.entity.ParcelEntity;
import com.routemasterapi.api.entity.RouteEntity;
 
@Repository
public interface  RouteRepository extends CrudRepository<RouteEntity, BigInteger> {
	
	@Query(value = "SELECT count(*) from piyush_routes", nativeQuery = true)
	String countNumberOfRoutes();

	@Query(value = "select * from  piyush_routes ", nativeQuery = true)
	Page<RouteEntity> listAllRoutesFromDB(Pageable pageable);
}