package com.routemasterapi.api.entity;

 import javax.persistence.*;
 
@Entity
@Table(name = "piyush_parcel")
public class ParcelEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parcelId", nullable = false)
	private int parcelId;
	
	@Column(name = "senderName", nullable = false) 
	private String  senderName;
	
	@Column(name = "destinationAddress", nullable = false) 
	private String  destinationAddress;
	
	@Column(name = "destinationPincode", nullable = false) 
	private String  destinationPincode;
	
	@Column(name = "receiverName", nullable = false) 
	private String  receiverName;
	
	@Column(name = "parcelStatus", nullable = false) 
	private String  parcelStatus;

	public int getParcelId() {
		return parcelId;
	}

	public void setParcelId(int parcelId) {
		this.parcelId = parcelId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public String getDestinationPincode() {
		return destinationPincode;
	}

	public void setDestinationPincode(String destinationPincode) {
		this.destinationPincode = destinationPincode;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getParcelStatus() {
		return parcelStatus;
	}

	public void setParcelStatus(String parcelStatus) {
		this.parcelStatus = parcelStatus;
	}
	
 
}
