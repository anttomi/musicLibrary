package com.example.musiclibrary;

import java.util.ArrayList;
import java.util.List;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


import org.springframework.security.provisioning.InMemoryUserDetailsManager;




@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled= true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http
	.authorizeRequests()
		.antMatchers("/", "/login", "/songs", "/playlistlist", "/playlistsongs").permitAll()
		.anyRequest().authenticated()
		.and()
	.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/library", true)
		.permitAll()
		.and()
	.logout()
		.permitAll();
	
	
	}

    	@Bean
	@Override
	public UserDetailsService userDetailsService() {
	
	List<UserDetails> users = new ArrayList<>();
	    UserDetails user1 = User.withDefaultPasswordEncoder()
		    .username("user")
		    .password("password")
		    .roles("USER")
		    .build();
	    
	    
	    UserDetails user2 = User.withDefaultPasswordEncoder()
		    .username("admin")
		    .password("admin")
		    .roles("USER", "ADMIN")
		    .build();
	    
	    users.add(user1);
	    users.add(user2);
		    
	    		
	    return new InMemoryUserDetailsManager(users);
    
    }
    

    
    
}

