package com.routemasterapi.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.routemasterapi.api.entity.Parcel;

@Repository
public interface  ParcelRepository extends CrudRepository<Parcel,Integer> {
	
	@Query(value = "SELECT count(*) from abhigya_parcel", nativeQuery = true)
	String countNumberOfParcels();

	@Query(value = "select * from  abhigya_parcel ", nativeQuery = true)
	Page<Parcel> listallparcelsfromdb(Pageable pageable);



	



}
