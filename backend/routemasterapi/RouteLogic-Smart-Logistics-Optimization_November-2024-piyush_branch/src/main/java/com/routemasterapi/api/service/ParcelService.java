package com.routemasterapi.api.service;

import com.routemasterapi.api.entity.ParcelEntity;
import com.routemasterapi.api.model.ParcelIdRequest;
import com.routemasterapi.api.model.ParcelRequestBody; 
import com.routemasterapi.api.repositories.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
public class ParcelService  {

	@Autowired
	private ParcelRepository parcelRepository;

	@Autowired
	private EmailService emailService;

	public ParcelEntity createParcel(ParcelRequestBody parcelReqBody) {

		ParcelEntity newParcel = new ParcelEntity();
		newParcel.setSenderName(parcelReqBody.getSenderName());
		newParcel.setReceiverName(parcelReqBody.getReceiverName());
		newParcel.setDestinationAddress(parcelReqBody.getDestinationAddress());
		newParcel.setDestinationPincode(parcelReqBody.getDestinationPincode());
		newParcel.setParcelStatus(parcelReqBody.getParcelStatus());
		
		emailService.sendEmail(
				"piyushoa2004@gmail.com", 
				"Parcel created successfully", 
				String.format("Hi %s, your parcel has been created successfully with parcelId %s", parcelReqBody.getSenderName(), parcelReqBody.getParcelId())
		);
		
		return parcelRepository.save(newParcel);		 
	}

	public ParcelEntity updateParcel(ParcelRequestBody parcelReqBody) {
		ParcelEntity newParcel = new ParcelEntity();
		newParcel.setParcelId(parcelReqBody.getParcelId());
		newParcel.setSenderName(parcelReqBody.getSenderName());
		newParcel.setReceiverName(parcelReqBody.getReceiverName());
		newParcel.setDestinationAddress(parcelReqBody.getDestinationAddress());
		newParcel.setDestinationPincode(parcelReqBody.getDestinationPincode());
		newParcel.setParcelStatus(parcelReqBody.getParcelStatus());
		
		emailService.sendEmail(
				"piyushoa2004@gmail.com", 
				"Parcel Update", 
				String.format("Hi %s, your parcel status is: %s ", parcelReqBody.getSenderName(), parcelReqBody.getParcelStatus())
		);
		
		return parcelRepository.save(newParcel);		 
	}

	public Page<ParcelEntity> listallparcelsfromdb(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return parcelRepository.listallparcelsfromdb(pageable);
	}
 
	public String deleteParcel(ParcelIdRequest parcelIdReq) {
		int ParcelId= parcelIdReq.getParcelId();
		parcelRepository.deleteById(ParcelId);
		return "Record Deleted";
	}

	public String countNumberOfParcels() {
		// TODO Auto-generated method stub
		return parcelRepository.countNumberOfParcels();
	}

}
