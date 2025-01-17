package com.routemasterapi.api.repositories;


import com.routemasterapi.api.entity.TrackParcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackParcelRepository extends JpaRepository<TrackParcel, Long> {

}

