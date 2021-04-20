package com.example.musiclibrary.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Playlist {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="playlist")
    private List<Song> songs;
    
 
    public Playlist() {
    }
    
    public Playlist(String name) {
	super();
	this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }


    public void setName(String name) {
        this.name = name;
    }
    
    public Long getId() {
	return this.id;
    }
}