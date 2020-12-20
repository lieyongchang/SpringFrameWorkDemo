package com.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
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
		    /*.antMatchers().hasRole("ADMIN")*/
			.antMatchers("/","/userList/**")
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
						
						HttpSession ss = request.getSession();
						ss.setMaxInactiveInterval(60); 
	                    System.out.print("session expired");
						
					}
                })
				.loginProcessingUrl("/userList").permitAll()
				.and()
				.logout();

		http.headers().frameOptions().disable();

	}
	

}