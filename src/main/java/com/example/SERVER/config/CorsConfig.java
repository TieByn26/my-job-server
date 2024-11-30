package com.example.SERVER.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class CorsConfig {
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowCredentials(true);
		configuration.setAllowedOrigins(Arrays.asList(
				"http://localhost:3000",
				"http://localhost:4173",
				"http://localhost:5173")
		);
		configuration.setAllowedMethods(Arrays.asList(
				"GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"
		));
		configuration.setAllowedHeaders(Arrays.asList(
				"Authorization", "Content-Type", "Accept", "x-no-retry"
		));
		configuration.setMaxAge(3600L); // Cache thời gian cho pre-flight request
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration); // Áp dụng config cho tất cả endpoint
		return source;
	}
}