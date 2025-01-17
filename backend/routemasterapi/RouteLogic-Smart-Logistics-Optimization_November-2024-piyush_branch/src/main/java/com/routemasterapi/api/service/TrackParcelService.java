package com.routemasterapi.api.service;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.routemasterapi.api.entity.TrackParcelEntity;
import com.routemasterapi.api.model.TrackParcelIdRequest;
import com.routemasterapi.api.model.TrackParcelRequestBody;
import com.routemasterapi.api.repositories.TrackParcelRepository;

@Service
public class TrackParcelService {
	
	@Autowired
	private TrackParcelRepository trackParcelRepository;
	
	public TrackParcelEntity createTrackParcel(TrackParcelRequestBody trackParcelReqBody ) {
		
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		
		TrackParcelEntity newTrackParcel = new TrackParcelEntity();
		newTrackParcel.setParcelId(trackParcelReqBody.getParcelId());
		newTrackParcel.setParcelStatus(trackParcelReqBody.getParcelStatus());
		newTrackParcel.setEmployeeId(trackParcelReqBody.getEmployeeId());
		newTrackParcel.setApproveReject(trackParcelReqBody.getApproveReject());
		newTrackParcel.setTimestamp(currentTimestamp);
		return	trackParcelRepository.save(newTrackParcel);	
	}
	
	public TrackParcelEntity updateTrackParcel(TrackParcelRequestBody trackParcelReqBody ) {
		
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		
		TrackParcelEntity newTrackParcel = new TrackParcelEntity();
		newTrackParcel.setTrackParcelId(trackParcelReqBody.getTrackParcelId());
		newTrackParcel.setParcelId(trackParcelReqBody.getParcelId());
		newTrackParcel.setParcelStatus(trackParcelReqBody.getParcelStatus());
		newTrackParcel.setEmployeeId(trackParcelReqBody.getEmployeeId());
		newTrackParcel.setApproveReject(trackParcelReqBody.getApproveReject());
		newTrackParcel.setTimestamp(currentTimestamp);
		return	trackParcelRepository.save(newTrackParcel);	
	}
	
	public Page<TrackParcelEntity> listAllTrackParcelsFromDB(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return trackParcelRepository.listAllTrackParcelsFromDB(pageable);
	}
	
	public String deleteTrackParcel(TrackParcelIdRequest trackParcelIdReq) {
		BigInteger trackParcelId = trackParcelIdReq.getTrackParcelId();
		trackParcelRepository.deleteById(trackParcelId);
		return "Record Deleted Successfully";
	}
	
	public String countNumberOfTrackParcels() {
		return trackParcelRepository.countNumberOfTrackParcels();
	}
}