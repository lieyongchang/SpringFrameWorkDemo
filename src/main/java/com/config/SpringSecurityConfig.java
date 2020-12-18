package com.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configurable
//@Configuration
//@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	// roles admin allow to access /admin/**
	// roles user allow to access /user/**
	// custom 403 access denied handler
	// @formatter:off
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// @formatter:off
//		http.formLogin().defaultSuccessUrl("/usersList", true);

		// @formatter:off
		http.authorizeRequests()
			.antMatchers("/", "/user/userList/*").permitAll().anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/usersList", true).permitAll()
					.and()
				.logout().permitAll();

		http.csrf().disable();
		http.headers().frameOptions().disable();

	}
}