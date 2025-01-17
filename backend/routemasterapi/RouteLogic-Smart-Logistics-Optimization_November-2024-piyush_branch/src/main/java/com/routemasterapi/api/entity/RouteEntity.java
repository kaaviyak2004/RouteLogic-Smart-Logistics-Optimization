package com.routemasterapi.api.entity;

import java.math.BigInteger;
import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "piyush_routes")
public class RouteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "routeId", nullable = false)
	private BigInteger routeId;
	
	@Column(name = "routeName", nullable = false) 
	private String  routeName;
	
	@Column(name = "description", nullable = false) 
	private String  description;
	
	@Column(name = "originPincode", nullable = false) 
	private String  originPincode;
	
	@Column(name = "destinationPincode", nullable = false) 
	private String  destinationPincode;
	
	@Column(name = "totalDistance", nullable = false) 
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