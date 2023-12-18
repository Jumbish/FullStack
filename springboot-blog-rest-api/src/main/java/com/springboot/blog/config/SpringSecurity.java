package com.springboot.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springboot.blog.security.JWTAuthFilter;
import com.springboot.blog.security.JwtAuthEntryPoint;

@Configuration
@EnableMethodSecurity
public class SpringSecurity {
//	Instead of injecting the class object directly , we use the interface to achieve the loose coupling
	private UserDetailsService userDetailsService;

	private JwtAuthEntryPoint authEntryPoint;

	private JWTAuthFilter jwtAuthFilter;

	public SpringSecurity(UserDetailsService userDetailsService, JwtAuthEntryPoint authEntryPoint, JWTAuthFilter jwtAuthFilter) {
		this.userDetailsService = userDetailsService;
		this.authEntryPoint = authEntryPoint;
		this.jwtAuthFilter = jwtAuthFilter;
		// TODO Auto-generated constructor stub
	}

//	Created to authticate the userDetailsService
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeHttpRequests((authorize) ->
//		authorize.anyRequest().authenticated()
		authorize.requestMatchers(HttpMethod.GET, "/api/**").permitAll()
				.requestMatchers("/api/auth/**").permitAll()
				.requestMatchers("/swagger-ui/**").permitAll()
				.requestMatchers("/v3/api-docs/**").permitAll()
				.anyRequest().authenticated())
				.exceptionHandling(exception -> exception.authenticationEntryPoint(authEntryPoint))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();

	}

//	@Bean
//	public UserDetailsService userDetailsService() {
//
//		UserDetails ramesh = User.builder().username("ramesh").password(passwordEncoder().encode("ramesh"))
//				.roles("USER").build();
//
//		UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
//				.build();
//
//		return new InMemoryUserDetailsManager(ramesh, admin);
//
//	}

}
