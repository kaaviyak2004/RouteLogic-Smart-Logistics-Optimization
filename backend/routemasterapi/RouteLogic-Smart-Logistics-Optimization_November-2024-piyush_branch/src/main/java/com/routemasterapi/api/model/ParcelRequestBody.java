package com.routemasterapi.api.model;
 
public class ParcelRequestBody { 
		 
		private int parcelId;
		
 		private String  senderName;
		
 		private String  destinationAddress;
		
 		private String  destinationPincode;
		
 		private String  receiverName;
		
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
