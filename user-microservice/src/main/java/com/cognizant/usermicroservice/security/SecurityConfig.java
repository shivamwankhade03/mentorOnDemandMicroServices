package com.cognizant.usermicroservice.security;

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
		httpSecurity.csrf().disable().httpBasic().and().authorizeRequests().antMatchers("/user/**").permitAll()
				.antMatchers("/mentor/addSkills/**").permitAll() // .hasRole("m")
				.antMatchers("/mentor/**").permitAll().anyRequest().authenticated().and()
				.addFilter(new JwtAuthorizationFilter(authenticationManager()));
	}
}
