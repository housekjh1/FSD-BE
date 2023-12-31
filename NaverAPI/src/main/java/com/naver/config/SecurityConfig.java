package com.naver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private final OAuth2AuthorizedClientService authorizedClientService;

	public SecurityConfig(OAuth2AuthorizedClientService authorizedClientService) {
		this.authorizedClientService = authorizedClientService;
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable());

		http.authorizeHttpRequests(authz -> authz.requestMatchers("/**").permitAll().anyRequest().authenticated())
				.oauth2Login(oauth2 -> oauth2
						.successHandler(new CustomAuthenticationSuccessHandler(authorizedClientService)));

		http.formLogin(frm -> frm.disable());
		http.httpBasic(bs -> bs.disable());

		return http.build();
	}
}
