package com.greatlearning.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.service.DomainUserDetailsService;

@Configuration
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private DomainUserDetailsService dudService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.dudService)
		.passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//authorization
		http.cors().disable();
		http.csrf().disable(); 
		http.headers().frameOptions().disable();
		http.authorizeRequests()
		   .antMatchers("/h2-console/**")
		   .permitAll()
		   .antMatchers(HttpMethod.GET,"/employees*","/employees/**")
		   .hasAnyRole("USER","ADMIN")
		   .antMatchers(HttpMethod.PUT,"/employees*","/employees/**")
		   .hasRole("ADMIN")
		   .antMatchers(HttpMethod.POST,"/employees*","/employees/**")
		   .hasRole("ADMIN")
		   .anyRequest().authenticated()
		   .and()
		   .httpBasic();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
