package com.routemasterapi.api.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.routemasterapi.api.entity.RouteEntity;
import com.routemasterapi.api.entity.UsersEntity;
import com.routemasterapi.api.model.RouteIdRequest;
import com.routemasterapi.api.model.RouteRequestBody;
import com.routemasterapi.api.model.UserIdRequest;
import com.routemasterapi.api.model.UserRequestBody;
import com.routemasterapi.api.repositories.RouteRepository;
import com.routemasterapi.api.repositories.UsersRepository;

@Service
public class RouteService {
	
	@Autowired
	private RouteRepository routeRepository;
	
	public RouteEntity createRoute(RouteRequestBody routeReqBody) {
		RouteEntity newRoute = new RouteEntity();
		
		newRoute.setRouteName(routeReqBody.getRouteName());
		newRoute.setDescription(routeReqBody.getDescription());
		newRoute.setOriginPincode(routeReqBody.getOriginPincode());
		newRoute.setDestinationPincode(routeReqBody.getDestinationPincode());
		newRoute.setTotalDistance(routeReqBody.getTotalDistance());
		return routeRepository.save(newRoute);
	}
	
	public RouteEntity updateRoute(RouteRequestBody routeReqBody) {
		RouteEntity newRoute = new RouteEntity();
		
		newRoute.setRouteId(routeReqBody.getRouteId());
		newRoute.setRouteName(routeReqBody.getRouteName());
		newRoute.setDescription(routeReqBody.getDescription());
		newRoute.setOriginPincode(routeReqBody.getOriginPincode());
		newRoute.setDestinationPincode(routeReqBody.getDestinationPincode());
		newRoute.setTotalDistance(routeReqBody.getTotalDistance());
		return routeRepository.save(newRoute);
	}
	
	public Page<RouteEntity> listAllRoutesFromDB(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return routeRepository.listAllRoutesFromDB(pageable);
	}
	
	public String deleteUser(RouteIdRequest routeIdReq) {
		BigInteger routeId = routeIdReq.getRouteId();
		routeRepository.deleteById(routeId);
		return "Record Deleted Successfully";
	}
	
	public String countNumberofRoutes() {
		return routeRepository.countNumberOfRoutes();
	}
}