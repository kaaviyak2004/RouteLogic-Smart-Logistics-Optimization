package com.routemasterapi.api.service;

import com.routemasterapi.api.entity.Route;
import com.routemasterapi.api.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public Route addRoute(Route route) {
        return routeRepository.save(route);
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public Optional<Route> getRouteById(Long routeId) {
        return routeRepository.findById(routeId);
    }

    public Route updateRoute(Long routeId, Route updatedRoute) {
        return routeRepository.findById(routeId).map(route -> {
            route.setRouteName(updatedRoute.getRouteName());
            route.setDescription(updatedRoute.getDescription());
            route.setOriginPincode(updatedRoute.getOriginPincode());
            route.setDestinationPincode(updatedRoute.getDestinationPincode());
            route.setTotalDistance(updatedRoute.getTotalDistance());
            return routeRepository.save(route);
        }).orElseThrow(() -> new RuntimeException("Route not found with ID: " + routeId));
    }

    public void deleteRoute(Long routeId) {
        routeRepository.deleteById(routeId);
    }
}
