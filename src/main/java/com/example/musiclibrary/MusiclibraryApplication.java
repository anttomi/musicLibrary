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

		User user1 = new User("user", "$2a$10$U0021easazMrjG1E2VfKe.ptEgHYSW6RuGTnJFPFAUrBHTXaJUNwC", "USER", "user@user.com");
		User user2 = new User("admin", "$2a$10$LWRNHeTjf/5FryyyIsUbKezOH1qqqOfJ45smIBjMcpeYP.FmWHscC", "ADMIN", "admin@admin.com");
		uRep.deleteAll();
		uRep.save(user1);
		uRep.save(user2);
	    };
	}

}
