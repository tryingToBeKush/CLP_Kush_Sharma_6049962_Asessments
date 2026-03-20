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
        return ResponseEntity.ok("Track added successfully");
    }

    @GetMapping("/tracks")
    public ResponseEntity<List<Track>> getTracks() {
        return ResponseEntity.ok(trackRepo.findAll());
    }

    @GetMapping("/tracks/album/{albumName}")
    public ResponseEntity<List<Track>> getTracksByAlbum(@PathVariable String albumName) {
        return ResponseEntity.ok(trackRepo.findByAlbumName(albumName));
    }

    @GetMapping("/tracks/{id}")
    public ResponseEntity<Track> getTrackById(@PathVariable long id) {
        return ResponseEntity.ok(trackRepo.findById(id).orElse(null));
    }
}