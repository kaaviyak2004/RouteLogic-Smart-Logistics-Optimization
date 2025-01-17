package com.routemasterapi.api.model;

import java.math.BigInteger;
import java.text.DecimalFormat;

public class RouteRequestBody {

	private BigInteger routeId;
	private String  routeName;
	private String  description;
	private String  originPincode;
	private String  destinationPincode;
	private Integer  totalDistance;

	
	public BigInteger getRouteId() {
		return routeId;
	}

	public void setRouteId(BigInteger routeId) {
		this.routeId = routeId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOriginPincode() {
		return originPincode;
	}

	public void setOriginPincode(String originPincode) {
		this.originPincode = originPincode;
	}
	
	public String getDestinationPincode() {
		return destinationPincode;
	}

	public void setDestinationPincode(String destinationPincode) {
		this.destinationPincode = destinationPincode;
	}

	public Integer getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(Integer totalDistance) {
		this.totalDistance = totalDistance;
	} 
}