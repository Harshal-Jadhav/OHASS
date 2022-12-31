package com.masai.Security.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.antMatchers("/demo/addUsers", "/demo/addAdmin").hasAuthority("ADMIN")
				.antMatchers("/demo/getAccount").hasAuthority("USER").antMatchers("get-all-users").permitAll()).csrf()
				.disable().httpBasic();
		return http.build();
	}
}
