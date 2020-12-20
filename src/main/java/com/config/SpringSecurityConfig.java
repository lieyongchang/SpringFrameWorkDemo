package com.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

//@Configurable
@Configuration
@EnableWebSecurity
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
		http.csrf().disable()
		    .authorizeRequests()
		    .antMatchers("/userList/**").hasRole("ADMIN")
		    .antMatchers("/login*").permitAll()
			.antMatchers("/","/userList")
			.permitAll().anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login").permitAll()
				.defaultSuccessUrl("/usersList", true)
					.successHandler(new AuthenticationSuccessHandler() {
					@Override
					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
							Authentication authentication) throws IOException, ServletException {
						System.out.println("enter here: ");
						System.out.println("session: " +  request.getSession());
						request.getSession().setMaxInactiveInterval(60);
						
	                    System.out.print("session expired");
						
					}
                })
//				.loginProcessingUrl("/userList").permitAll()
				.and()
				.logout();

		http.headers().frameOptions().disable();

	}
	
	// In-memory authentication to authenticate the user i.e. the user credentials are stored in the memory.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("guest").password("{noop}guest").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
	}

/*	@Bean 
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}*/
}