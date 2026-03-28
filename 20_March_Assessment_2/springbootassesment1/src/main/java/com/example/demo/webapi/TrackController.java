package com.example.demo.webapi;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Track;
import com.example.demo.repo.TrackRepo;

@RestController
public class TrackController {

    @Autowired
    private TrackRepo trackRepo;

    @PostMapping("/tracks")
    public ResponseEntity<String> addTrack(@RequestBody Track newTrack) {
        trackRepo.save(newTrack);
        return ResponseEntity.status(201).body("Track added successfully");
    }

    @GetMapping("/tracks")
    public ResponseEntity<List<Track>> getTracks() {
        return ResponseEntity.ok(trackRepo.findAll());
    }

    @GetMapping("/tracks/title/{title}")
    public ResponseEntity<?> getTracksByTitle(@PathVariable String title) {
        List<Track> tracks = trackRepo.findByTitle(title);
        if(!tracks.isEmpty()) {
            return ResponseEntity.ok(tracks);
        } else {
            return ResponseEntity.status(404).body("Track not found");
        }
    }

    @GetMapping("/tracks/id/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable Long id) {
        Optional<Track> track = trackRepo.findById(id);
        if(track.isPresent()) {
            return ResponseEntity.ok(track.get());
        } else {
            return ResponseEntity.status(404).body("Track not found");
        }
    }
}