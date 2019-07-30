package com.xantrix.webapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static String REALM = "REAME";
	
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
	
	private static final String[] USER_MATCHER = { "/api/articoli/cerca/**"};
	private static final String[] ADMIN_MATCHER = { "/api/articoli/inserisci/**", 
			"/api/articoli/modifica/**", "/api/articoli/elimina/**" };
	
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeRequests()
				.antMatchers(USER_MATCHER).hasAnyRole("USER")
				.antMatchers(ADMIN_MATCHER).hasAnyRole("ADMIN")
				.anyRequest().authenticated()
				.and()
				.httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint())
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Bean
	public AuthEntryPoint getBasicAuthEntryPoint() {
		return new AuthEntryPoint();
	}
	
}
