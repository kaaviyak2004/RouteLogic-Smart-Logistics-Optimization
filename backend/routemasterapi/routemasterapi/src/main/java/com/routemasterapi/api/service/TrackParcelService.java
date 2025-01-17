package com.routemasterapi.api.service;



import com.routemasterapi.api.entity.TrackParcel;
import com.routemasterapi.api.repositories.TrackParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackParcelService {

    @Autowired
    private TrackParcelRepository trackParcelRepository;

    public List<TrackParcel> getAllTrackParcels() {
        return trackParcelRepository.findAll();
    }

    public TrackParcel getTrackParcelById(Long id) {
        return trackParcelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TrackParcel not found with id: " + id));
    }

    public TrackParcel createTrackParcel(TrackParcel trackParcel) {
        return trackParcelRepository.save(trackParcel);
    }

    public TrackParcel updateTrackParcel(Long id, TrackParcel updatedTrackParcel) {
        TrackParcel existingTrackParcel = getTrackParcelById(id);
        existingTrackParcel.setParcelId(updatedTrackParcel.getParcelId());
        existingTrackParcel.setParcelStatus(updatedTrackParcel.getParcelStatus());
        existingTrackParcel.setEmployeeId(updatedTrackParcel.getEmployeeId());
        existingTrackParcel.setApproveReject(updatedTrackParcel.getApproveReject());
        existingTrackParcel.setTimestamp(updatedTrackParcel.getTimestamp());
        return trackParcelRepository.save(existingTrackParcel);
    }

    public void deleteTrackParcel(Long id) {
        trackParcelRepository.deleteById(id);
    }
}

