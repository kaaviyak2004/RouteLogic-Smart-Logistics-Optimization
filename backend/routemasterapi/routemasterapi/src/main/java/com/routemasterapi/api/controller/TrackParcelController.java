package com.routemasterapi.api.controller;
import com.routemasterapi.api.entity.TrackParcel;
import com.routemasterapi.api.service.TrackParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/trackparcel")
public class TrackParcelController {

    @Autowired
    private TrackParcelService trackParcelService;

    @GetMapping
    public List<TrackParcel> getAllTrackParcels() {
        return trackParcelService.getAllTrackParcels();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackParcel> getTrackParcelById(@PathVariable Long id) {
        return ResponseEntity.ok(trackParcelService.getTrackParcelById(id));
    }

    @PostMapping
    public ResponseEntity<TrackParcel> createTrackParcel(@RequestBody TrackParcel trackParcel) {
        return ResponseEntity.ok(trackParcelService.createTrackParcel(trackParcel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrackParcel> updateTrackParcel(@PathVariable Long id, @RequestBody TrackParcel updatedTrackParcel) {
        return ResponseEntity.ok(trackParcelService.updateTrackParcel(id, updatedTrackParcel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrackParcel(@PathVariable Long id) {
        trackParcelService.deleteTrackParcel(id);
        return ResponseEntity.noContent().build();
    }
}

