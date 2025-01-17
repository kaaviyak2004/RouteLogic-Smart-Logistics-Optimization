package com.routemasterapi.api.entity;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "piyush_trackparcel")
public class TrackParcelEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trackParcelId", nullable = false)
	private BigInteger trackParcelId;
	
	@Column(name = "parcelId", nullable = false)
	private BigInteger parcelId;
	
	@Column(name = "parcelStatus", nullable = false) 
	private String parcelStatus;
	
	@Column(name = "employeeId", nullable = false)
	private BigInteger employeeId;
	
	@Column(name = "approveReject", nullable = false)
	private String approveReject;
		
	@Column(name = "timestamp", nullable = false)
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