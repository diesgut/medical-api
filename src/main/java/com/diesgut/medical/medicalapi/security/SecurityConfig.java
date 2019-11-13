package com.diesgut.medical.medicalapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter { 
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception{
		String bcryptPassword = passwordEncoder.encode("1234");
		auth.inMemoryAuthentication().withUser("medicalapi").password(bcryptPassword).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user").password("b14361404c078ffd549c03db443c3fede2f3e534d73f78f77301ed97d4a436a9fd9db05ee8b325c0ad36438b43fec8510c204fc1c1edb21d0941c00e9e2c1ce2").roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//autenticacion básica (base 64)
		http.csrf().disable().authorizeRequests()
	//	.antMatchers("/doctors").permitAll()
		.antMatchers("/doctors/**").hasRole("ADMIN")
		.antMatchers("/patients/**").hasRole("ADMIN")
		.antMatchers("/specialities/**").hasRole("ADMIN")
		//.antMatchers("/*/escribirDB/**").hasRole("ADMIN")
		.and()
		.httpBasic();
	}
	

	//spring security pide encriptar las contraseñas
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
