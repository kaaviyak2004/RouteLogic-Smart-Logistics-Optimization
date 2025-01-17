package com.routemasterapi.api.repositories;

import java.math.BigInteger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.routemasterapi.api.entity.ParcelEntity;
import com.routemasterapi.api.entity.TrackParcelEntity;

@Repository
public interface  TrackParcelRepository extends CrudRepository<TrackParcelEntity,BigInteger> {
	@Query(value = "SELECT count(*) from piyush_trackparcel", nativeQuery = true)
	String countNumberOfTrackParcels();

	@Query(value = "select * from  piyush_trackparcel ", nativeQuery = true)
	Page<TrackParcelEntity> listAllTrackParcelsFromDB(Pageable pageable);
}