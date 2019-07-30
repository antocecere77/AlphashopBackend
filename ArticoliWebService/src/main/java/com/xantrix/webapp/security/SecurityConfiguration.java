package com.xantrix.webapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		
		UserBuilder users = User.builder();
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		
		manager.createUser(users.username("antonio")
				.password(new BCryptPasswordEncoder().encode("12345678"))
				.roles("USER")
				.build());
		
		manager.createUser(users.username("admin")
				.password(new BCryptPasswordEncoder().encode("12345678"))
				.roles("ADMIN")
				.build());
		
		return manager;
	}
	
	
	
}
