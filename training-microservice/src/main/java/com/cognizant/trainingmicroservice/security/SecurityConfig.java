package com.cognizant.trainingmicroservice.security;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors();
		httpSecurity.csrf().disable().httpBasic().and().authorizeRequests().antMatchers("/trainings/user/**")
				.permitAll() // hasRole("u")
				.antMatchers("/trainings/mentor/**").permitAll() // hasRole("m")
				.antMatchers("/trainings/update/**").permitAll() // hasAnyRole("m","u")
				.anyRequest().authenticated().and().addFilter(new JwtAuthorizationFilter(authenticationManager()));
	}
}
