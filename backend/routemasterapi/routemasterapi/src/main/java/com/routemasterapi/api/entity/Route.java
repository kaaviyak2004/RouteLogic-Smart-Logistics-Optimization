package com.routemasterapi.api.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "abhigya_routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;

    @Column(name = "routeName", nullable = false)
    private String routeName;

    @Column(name = "description")
    private String description;

    @Column(name = "originPincode", nullable = false)
    private String originPincode;

    @Column(name = "destinationPincode", nullable = false)
    private String destinationPincode;

    @Column(name = "totalDistance", precision = 10, scale = 2)
    private Double totalDistance;
}
