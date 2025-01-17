package com.routemasterapi.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.routemasterapi.api.entity.ParcelEntity;
 
@Repository
public interface  ParcelRepository extends CrudRepository<ParcelEntity,Integer> {
	
	@Query(value = "SELECT count(*) from piyush_parcel", nativeQuery = true)
	String countNumberOfParcels();

	@Query(value = "select * from  piyush_parcel ", nativeQuery = true)
	Page<ParcelEntity> listallparcelsfromdb(Pageable pageable);
}