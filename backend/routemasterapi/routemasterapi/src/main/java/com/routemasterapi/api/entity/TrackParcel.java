package com.routemasterapi.api.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "abhigya_trackparcel")
public class TrackParcel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trackParcelId;

    @Column(name = "parcelId", nullable = false)
    private Long parcelId;

    @Column(name = "parcelStatus", length = 25)
    private String parcelStatus;

    @Column(name = "employeeId")
    private Long employeeId;

    @Column(name = "approveReject", length = 10)
    private String approveReject;

    @Column(name = "timestamp")
    @Temporal(TemporalType.DATE)
    private Date timestamp;
}
