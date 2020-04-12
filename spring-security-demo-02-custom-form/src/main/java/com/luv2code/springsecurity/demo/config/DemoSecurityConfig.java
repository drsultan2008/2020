package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder user = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(user.username("duy").password("duyduy").roles("ADMIN","EMPLOYEE"))
		.withUser(user.username("pro").password("propro").roles("EMPLOYEE"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").hasRole("EMPLOYEE").antMatchers("/leaders/**").hasRole("ADMIN").and().formLogin().loginPage("/showFormLogin").loginProcessingUrl("/authenticateTheUser").permitAll()
		.and().logout().permitAll();
	}
	
}
