package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configurable
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	//@formatter:off
		@Autowired
	    private AccessDeniedHandler accessDeniedHandler;

	    // roles admin allow to access /admin/**
	    // roles user allow to access /user/**
	    // custom 403 access denied handler
		//@formatter:off
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {

	        http.csrf().disable()
	                .authorizeRequests()
	                    .antMatchers("/").permitAll()
	                    .antMatchers("/user/userList/**").hasAnyRole("ADMIN")
	                 /*   .antMatchers("/user/**").hasAnyRole("USER")*/
	                    .anyRequest().authenticated()
	                .and()
	                .formLogin()
	                    .loginPage("/login")
	                    .permitAll()
	                    .and()
	                .logout()
	                    .permitAll()
	                    .and()
	                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	    }

	    // create two users, admin and user
	    //@formatter:off
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

	        auth.inMemoryAuthentication()
	                .withUser("user").password("password").roles("USER")
	                .and()
	                .withUser("admin").password("password").roles("ADMIN");
	    }
}
