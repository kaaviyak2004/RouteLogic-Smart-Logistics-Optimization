package com.routemasterapi.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "abhigya_parcel")
public class Parcel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parcelId", nullable = false)
	private int parcelId;

	@Column(name = "userId", nullable = false)
	private int userId;

	@Column(name = "receiverFirstName", nullable = false)
	private String receiverFirstName;

	@Column(name = "receiverLastName", nullable = false)
	private String receiverLastName;

	@Column(name = "pickupAddress", nullable = false)
	private String pickupAddress;

	@Column(name = "destinationAddress", nullable = false)
	private String destinationAddress;

	@Column(name = "receiverPhoneNumber", nullable = false)
	private String receiverPhoneNumber;

	@Column(name = "noOfItems", nullable = false)
	private int noOfItems;

	@Column(name = "itemType", nullable = false)
	private String itemType;

	@Column(name = "deliveryType", nullable = false)
	private String deliveryType;

	@Column(name = "fragileItem", nullable = false)
	private Boolean fragileItem;

	@Column(name = "totalBill", nullable = false)
	private String totalBill;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getParcelId() {
		return parcelId;
	}

	public void setParcelId(int parcelId) {
		this.parcelId = parcelId;
	}

	public String getReceiverFirstName() {
		return receiverFirstName;
	}

	public void setReceiverFirstName(String receiverFirstName) {
		this.receiverFirstName = receiverFirstName;
	}

	public String getReceiverLastName() {
		return receiverLastName;
	}

	public void setReceiverLastName(String receiverLastName) {
		this.receiverLastName = receiverLastName;
	}

	public String getPickupAddress() {
		return pickupAddress;
	}

	public void setPickupAddress(String pickupAddress) {
		this.pickupAddress = pickupAddress;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public String getReceiverPhoneNumber() {
		return receiverPhoneNumber;
	}

	public void setReceiverPhoneNumber(String receiverPhoneNumber) {
		this.receiverPhoneNumber = receiverPhoneNumber;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public Boolean getFragileItem() {
		return fragileItem;
	}

	public void setFragileItem(Boolean fragileItem) {
		this.fragileItem = fragileItem;
	}

	public String getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(String totalBill) {
		this.totalBill = totalBill;
	}
}
