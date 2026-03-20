package com.example.demo.entities;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "abes_track")
public class Track {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Track_id")
	private long id;
	@Column(name = "Track_title")
	private String title;
	@Column(name = "Album_name")
	private String albumName;
	@Column(name = "Release_date")
	private Date releaseDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
}
