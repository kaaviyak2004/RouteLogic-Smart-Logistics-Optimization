package com.routemasterapi.api.repositories;

import com.routemasterapi.api.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
}
