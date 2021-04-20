package com.example.musiclibrary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.musiclibrary.domain.User;
import com.example.musiclibrary.domain.UserRepository;
import com.example.musiclibrary.domain.Playlist;
import com.example.musiclibrary.domain.PlaylistRepository;
import com.example.musiclibrary.domain.Song;
import com.example.musiclibrary.domain.SongRepository;

@SpringBootApplication
public class MusiclibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusiclibraryApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(SongRepository sRepo, UserRepository uRep, PlaylistRepository pRepo) {
	    return (args) -> {
		Playlist p1 = new Playlist("ekalista");
		Playlist p2 = new Playlist("toinenlista");
		pRepo.save(p1);
		pRepo.save(p2);
		Song song1 = new Song("In My Time of Need", "Opeth", "Damnation", 2003, "Progressive rock", p1);
		Song song2 = new Song("Kontinuerlig drift", "Opeth", "In Cauda Venenum", 2019, "Progressive rock", p2);
		sRepo.save(song1);
		sRepo.save(song2);
		User user1 = new User("user", "$2a$10$U0021easazMrjG1E2VfKe.ptEgHYSW6RuGTnJFPFAUrBHTXaJUNwC", "USER", "user@user.com");
		User user2 = new User("admin", "$2a$10$LWRNHeTjf/5FryyyIsUbKezOH1qqqOfJ45smIBjMcpeYP.FmWHscC", "ADMIN", "admin@admin.com");
		uRep.save(user1);
		uRep.save(user2);
	    };
	}

}
