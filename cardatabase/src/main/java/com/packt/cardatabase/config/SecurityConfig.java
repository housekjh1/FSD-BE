package com.packt.cardatabase.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.packt.cardatabase.config.filter.JWTAuthenticationFilter;
import com.packt.cardatabase.config.filter.JWTAuthorizationFilter;
import com.packt.cardatabase.persistence.UserRepository;
import com.packt.cardatabase.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsServiceImpl udsi;
	
	@Autowired
	private AuthenticationConfiguration authConfig;
	
	@Autowired
	private UserRepository userRepo;
	
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf(csrf->csrf.disable());
		http.cors(cors->cors.disable());
		
		http.authorizeHttpRequests(auth->auth
				.requestMatchers(new AntPathRequestMatcher("/api/**")).authenticated()
				.anyRequest().permitAll());
		
		http.formLogin(frm->frm.disable());
		http.httpBasic(bs->bs.disable());
		
		http.addFilter(new JWTAuthenticationFilter(authConfig.getAuthenticationManager()));
		http.addFilterBefore(new JWTAuthorizationFilter(userRepo), AuthorizationFilter.class);
		http.addFilterBefore(new CustomConfig().corsFilter(), JWTAuthenticationFilter.class);
		
		return http.build();
	}
}
