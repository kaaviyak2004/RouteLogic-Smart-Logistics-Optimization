package com.routemasterapi.api.service;

import com.routemasterapi.api.entity.Parcel;
import com.routemasterapi.api.model.ParcelIdRequest;
import com.routemasterapi.api.model.ParcelRequestBody;
import com.routemasterapi.api.repositories.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ParcelService {

	@Autowired
	private ParcelRepository parcelRepository;

	@Autowired
	private EmailService emailService;

	public Parcel createParcel(ParcelRequestBody parcelReqBody) {
		Parcel newParcel = new Parcel();
		newParcel.setParcelId(parcelReqBody.getParcelId());
		newParcel.setUserId(parcelReqBody.getUserId());
		newParcel.setReceiverFirstName(parcelReqBody.getReceiverFirstName());
		newParcel.setReceiverLastName(parcelReqBody.getReceiverLastName());
		newParcel.setPickupAddress(parcelReqBody.getPickupAddress());
		newParcel.setDestinationAddress(parcelReqBody.getDestinationAddress());
		newParcel.setReceiverPhoneNumber(parcelReqBody.getReceiverPhoneNumber());
		newParcel.setNoOfItems(parcelReqBody.getNoOfItems());
		newParcel.setItemType(parcelReqBody.getItemType());
		newParcel.setDeliveryType(parcelReqBody.getDeliveryType());
		newParcel.setFragileItem(parcelReqBody.getFragileItem());
		newParcel.setTotalBill(parcelReqBody.getTotalBill());

		emailService.sendEmail(
				"piyushoa2004@gmail.com",
				"Parcel Created Successfully",
				String.format(
						"Hi %s, your parcel has been created successfully with Parcel ID %s",
						parcelReqBody.getReceiverFirstName(),
						parcelReqBody.getParcelId()
				)
		);

		return parcelRepository.save(newParcel);
	}

	public Parcel updateParcel(ParcelRequestBody parcelReqBody) {
		Optional<Parcel> optionalParcel = parcelRepository.findById(parcelReqBody.getParcelId());
		if (!optionalParcel.isPresent()) {
			throw new EntityNotFoundException("Parcel with ID " + parcelReqBody.getParcelId() + " not found.");
		}

		Parcel existingParcel = optionalParcel.get();
		existingParcel.setUserId(parcelReqBody.getUserId());
		existingParcel.setReceiverFirstName(parcelReqBody.getReceiverFirstName());
		existingParcel.setReceiverLastName(parcelReqBody.getReceiverLastName());
		existingParcel.setPickupAddress(parcelReqBody.getPickupAddress());
		existingParcel.setDestinationAddress(parcelReqBody.getDestinationAddress());
		existingParcel.setReceiverPhoneNumber(parcelReqBody.getReceiverPhoneNumber());
		existingParcel.setNoOfItems(parcelReqBody.getNoOfItems());
		existingParcel.setItemType(parcelReqBody.getItemType());
		existingParcel.setDeliveryType(parcelReqBody.getDeliveryType());
		existingParcel.setFragileItem(parcelReqBody.getFragileItem());
		existingParcel.setTotalBill(parcelReqBody.getTotalBill());

		emailService.sendEmail(
				"piyushoa2004@gmail.com",
				"Parcel Updated Successfully",
				String.format(
						"Hi %s, your parcel status has been updated successfully.",
						parcelReqBody.getReceiverFirstName()
				)
		);

		return parcelRepository.save(existingParcel);
	}

	public Page<Parcel> listallparcelsfromdb(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return parcelRepository.listallparcelsfromdb(pageable);
	}

	public String deleteParcel(ParcelIdRequest parcelIdReq) {
		int parcelId = parcelIdReq.getParcelId();
		parcelRepository.deleteById(parcelId);
		return "Record Deleted";
	}

	public String countNumberOfParcels() {
		return parcelRepository.countNumberOfParcels();
	}

	public Parcel approveParcel(int parcelId) {
		Optional<Parcel> optionalParcel = parcelRepository.findById(parcelId);
		if (!optionalParcel.isPresent()) {
			throw new EntityNotFoundException("Parcel with ID " + parcelId + " not found.");
		}

		Parcel parcel = optionalParcel.get();
		parcel.setDeliveryType("Approved");
		return parcelRepository.save(parcel);
	}
}
