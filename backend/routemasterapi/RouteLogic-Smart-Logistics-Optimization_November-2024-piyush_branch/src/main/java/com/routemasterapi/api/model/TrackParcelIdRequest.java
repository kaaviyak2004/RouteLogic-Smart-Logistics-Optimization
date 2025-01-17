package com.routemasterapi.api.model;

import java.math.BigInteger;

public class TrackParcelIdRequest {
	private BigInteger trackParcelId;
	
	public BigInteger getTrackParcelId() {
		return trackParcelId;
	}

	public void getTrackParcelId(BigInteger trackparcelId) {
		this.trackParcelId = trackparcelId;
	}
}