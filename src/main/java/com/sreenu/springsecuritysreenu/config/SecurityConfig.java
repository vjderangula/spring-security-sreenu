package com.sreenu.springsecuritysreenu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http.csrf().disable()
		.authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())
		.httpBasic(Customizer.withDefaults());
		
		return http.build();
		
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails 	user = User.builder()
				.username("kumar1")
				.password(passwordEncoder().encode("derangula1"))
				.roles("ADMIN")
				.build();
		
		UserDetails 	user1 = User.builder()
				.username("kumar2")
				.password(passwordEncoder().encode("derangula2"))
				.roles("HR")
				.build();
		
		UserDetails 	user2 = User.builder()
				.username("kumar3")
				.password(passwordEncoder().encode("derangula3"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user, user1, user2);
		
		
	}

}
