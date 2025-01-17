package com.routemasterapi.api.controller;

import com.routemasterapi.api.entity.Parcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.routemasterapi.api.model.ParcelRequestBody;
import com.routemasterapi.api.model.ParcelIdRequest;
import com.routemasterapi.api.service.ParcelService;
  
@RestController
@CrossOrigin
public class ParcelController {
	
	@Autowired
	private ParcelService ParcelService;	
	
	@RequestMapping(value = "/createParcel", method = RequestMethod.POST)
	public ResponseEntity<?> createParcel(@RequestBody ParcelRequestBody ParcelReqBody) throws Exception {
		return ResponseEntity.ok(ParcelService.createParcel(ParcelReqBody));
	}
	
	@RequestMapping(value = "/updateParcel", method = RequestMethod.PUT)
	public ResponseEntity<?> updateParcel(@RequestBody ParcelRequestBody ParcelReqBody) throws Exception {
		return ResponseEntity.ok(ParcelService.updateParcel(ParcelReqBody));
	}		
	
	@RequestMapping(value = "/listAllParcels", method = RequestMethod.GET)
	public ResponseEntity<?> listAllParcels(@RequestParam(defaultValue = "0") final Integer pageNumber,
			@RequestParam(defaultValue = "10") final Integer size) throws Exception {
		return ResponseEntity.ok(ParcelService.listallparcelsfromdb(pageNumber, size));
	}		
	
	@RequestMapping(value = "/deleteParcel", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteParcel(@RequestBody ParcelIdRequest parcelIdRequest) throws Exception {
		return ResponseEntity.ok(ParcelService.deleteParcel(parcelIdRequest));
	}		
	@RequestMapping(value = "/parcelscount", method = RequestMethod.GET)
	public ResponseEntity<?> countNumberOfParcels() throws Exception {
		return ResponseEntity.ok((ParcelService.countNumberOfParcels()));
	}

	@PutMapping("/admin/approve/{parcelId}")
	public ResponseEntity<Parcel> approveParcel(@PathVariable int parcelId) {
		Parcel parcel = ParcelService.approveParcel(parcelId);
		return ResponseEntity.ok(parcel);
	}


}
