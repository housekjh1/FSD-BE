package com.recycle.config;

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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.recycle.config.filter.JWTAuthenticationFilter;
import com.recycle.config.filter.JWTAuthorizationFilter;
import com.recycle.persistence.MemberRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private AuthenticationConfiguration authConfig;
	
	@Autowired
	private MemberRepository memRepo;
	
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf(csrf->csrf.disable());
		http.cors(cors->cors.disable());
		
		http.authorizeHttpRequests(auth->auth
				.requestMatchers(new AntPathRequestMatcher("/**")).authenticated()
				.anyRequest().permitAll());
		
		http.formLogin(frm->frm.disable());
		http.httpBasic(bs->bs.disable());
		
		http.addFilter(new JWTAuthenticationFilter(authConfig.getAuthenticationManager()));
		http.addFilterBefore(new JWTAuthorizationFilter(memRepo), AuthorizationFilter.class);
		http.addFilterBefore(new CustomConfig().corsFilter(), JWTAuthenticationFilter.class);
		
		return http.build();
	}
}
