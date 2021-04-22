package com.example.musiclibrary.web;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.musiclibrary.domain.Playlist;
import com.example.musiclibrary.domain.PlaylistRepository;
import com.example.musiclibrary.domain.Song;
import com.example.musiclibrary.domain.SongRepository;

@Controller
public class SongController {
    
    @Autowired
    private SongRepository sRepo;
    @Autowired
    private PlaylistRepository pRepo;
    
    //Display all the songs and their attributes
    @GetMapping(value = "/library")
    public String songPage(Model model) {
	model.addAttribute("songs", sRepo.findAll());
	return "library";
    }
    
    //Display all playlists
    @GetMapping(value = "/playlists")
    public String playlistPage(Model model) {
	model.addAttribute("playlists", pRepo.findAll());
	return "playlists";
    }
    
    //Song rest, output all the songs to /songs, api
    @GetMapping(value = "/songs")
    public @ResponseBody List<Song> songListRest() {
	return (List<Song>) sRepo.findAll();
    }
    
    //Playlist rest, output all the playlists to /playlistlist, api
    @GetMapping(value = "/playlistlist")
    public @ResponseBody List<Playlist> playlistListRest() {
	return (List<Playlist>) pRepo.findAll();
    }
    
    //Direct to login page
    @GetMapping(value =  {"/login", "/"})
    public String login() {
	return "login";
    }
    
    //Add a song, sends playlists as an attribute aswell, because then you can add the song to a playlist
    @RequestMapping(value = "/add")
    public String addSong(Model model) {
	model.addAttribute("song", new Song());
	model.addAttribute("playlists", pRepo.findAll());
	return "songadd";
    }
    
    //Add a playlist
    @RequestMapping(value = "/addplaylist")
    public String addPlaylist(Model model) {
	model.addAttribute("playlist", new Playlist());
	return "playlistadd";
    }
    
    //Edit a song with the selected id 
    @GetMapping(value = "/edit/{id}")
    public String editSong(@PathVariable("id") Long songId, Model model) {
	model.addAttribute("song", sRepo.findById(songId));
	model.addAttribute("playlists", pRepo.findAll());
	return "editsong";
    }
    
    //Display playlists songs with the selected id 
    @GetMapping(value = "/playlistsongs/{id}")
    public String playlistsSongsPage(@PathVariable("id") Long playlistId, Model model) {
	model.addAttribute("playlistName", pRepo.findById(playlistId).get().getName());
	model.addAttribute("playlist", pRepo.findById(playlistId).get().getSongs());
	return "playlistssongs";
    }
    
    //Edit a playlist with the selected id 
    @GetMapping(value = "/editplaylist/{id}")
    public String editPlaylist(@PathVariable("id") Long playlistId, Model model) {
	model.addAttribute("playlist", pRepo.findById(playlistId));
	return "editplaylist";
    }
    
    //Song rest to get a song with selected id, api
    @GetMapping(value = "/song/{id}")
    public @ResponseBody Optional<Song> findSongRest(@PathVariable("id") Long songId) {
	return sRepo.findById(songId);
    }
    
    //Playlist rest to get a song with selected id, api
    @GetMapping(value = "/playlist/{id}")
    public @ResponseBody Optional<Playlist> findPlaylistRest(@PathVariable("id") Long playlistId) {
	return pRepo.findById(playlistId);
    }
    
    //Delete a song with selected id
    @GetMapping(value = "/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteSong(@PathVariable("id") Long songId, Model model) {
	sRepo.deleteById(songId);
	return "redirect:../library";
    }
    
    //save a song when edited
    @PostMapping(value = "/save")
    public String songSave(Song song) {
	sRepo.save(song);
	return "redirect:library";
    }

    //save a playlist when edited
    @PostMapping(value = "/saveplaylist")
    public String playlistSave(Playlist playlist) {
	pRepo.save(playlist);
	return "redirect:playlists";
    }


}
