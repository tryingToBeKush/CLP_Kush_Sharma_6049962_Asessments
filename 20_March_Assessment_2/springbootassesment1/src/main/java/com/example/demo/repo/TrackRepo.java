package com.example.demo.repo;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Track;

public interface TrackRepo extends JpaRepository<Track, Long> {
	List<Track> findByTitle(String title);
}
