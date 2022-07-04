package com.zensar.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/public/**").permitAll()
			.antMatchers("/student-api/**").hasRole("ADMIN")
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();

	}

	@Override 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("Aman").password(this.passwordEncoder().encode("12345")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("XYZ").password(this.passwordEncoder().encode("xyz")).roles("NORMAL");
	}
	 
	@Bean
	public PasswordEncoder passwordEncoder() {
		//return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder(10);
	}
	
}
