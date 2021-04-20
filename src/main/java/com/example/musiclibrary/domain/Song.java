package com.example.musiclibrary.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Song {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name,artist,album,genre;
    private int year;
    @ManyToOne
    @JoinColumn(name="playlist")
    private Playlist playlist;
    
    public Song () {
	
    }


    public Song(String name, String artist, String album, int year, String genre, Playlist playlist) {
	super();
	this.name = name;
	this.artist = artist;
	this.album = album;
	this.year = year;
	this.genre = genre;
	this.playlist = playlist;
	
    }

    public Playlist getPlaylist() {
        return playlist;
    }


    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public String getGenre() {
        return genre;
    }


    public void setGenre(String genre) {
        this.genre = genre;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getArtist() {
        return artist;
    }


    public void setArtist(String artist) {
        this.artist = artist;
    }


    public String getAlbum() {
        return album;
    }


    public void setAlbum(String album) {
        this.album = album;
    }


    public int getYear() {
        return year;
    }


    public void setYear(int year) {
        this.year = year;
    }
    
    @Override
    public String toString() {
	return "Song [id=" + id + ", name=" + name + ", artist=" + artist + ", album=" + album + ", genre=" + genre
		+ ", year=" + year + "]";
    }


}
