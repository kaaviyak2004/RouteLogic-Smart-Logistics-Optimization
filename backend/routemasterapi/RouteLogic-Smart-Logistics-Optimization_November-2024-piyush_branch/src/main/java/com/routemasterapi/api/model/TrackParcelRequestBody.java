package com.routemasterapi.api.model;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

public class TrackParcelRequestBody {

	private BigInteger trackParcelId;
	private BigInteger parcelId;
	private String parcelStatus;
	private BigInteger employeeId;
	private String approveReject;
	private Timestamp timestamp;

	public BigInteger getTrackParcelId() {
		return trackParcelId;
	}
	
	public void setTrackParcelId(BigInteger trackParcelId) {
		this.trackParcelId = trackParcelId;
	}
	
	public BigInteger getParcelId() {
		return parcelId;
	}
	
	public void setParcelId(BigInteger parcelId) {
		this.parcelId = parcelId;
	}
	
	public String getParcelStatus() {
		return parcelStatus;
	}
	
	public void setParcelStatus(String parcelStatus) {
		this.parcelStatus = parcelStatus;
	}
	
	public BigInteger getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(BigInteger employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getApproveReject() {
		return approveReject;
	}
	
	public void setApproveReject(String approveReject) {
		this.approveReject = approveReject;
	}
	
	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}