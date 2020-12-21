package com.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
//		    .antMatchers("/userList/**").hasRole("ADMIN")
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
						//System.out.println("enter here: ");
						//System.out.println("session: " +  request.getSession());
						response.sendRedirect("/userList");
						//System.out.print("session: " + request.getSession().getAttributeNames());
//						request.getSession().setMaxInactiveInterval(30);
						
	                   // System.out.print("session expired");
						
					}
                })
//				.loginProcessingUrl("/userList").permitAll()
				.and()
				.logout()
					.deleteCookies("JSESSIONID")
					.permitAll()
				.and()
				.sessionManagement()
					.invalidSessionUrl("/")
					.maximumSessions(1)
						.expiredUrl("/login");
					

		http.headers().frameOptions().disable();

	}
	
	// In-memory authentication to authenticate the user i.e. the user credentials are stored in the memory.
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("guest").password("{noop}guest").roles("USER");
//		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
//	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("user")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
	
	
}