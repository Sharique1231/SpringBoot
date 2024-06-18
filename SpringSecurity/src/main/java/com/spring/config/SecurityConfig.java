package com.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.entities.CustomUser;
import com.spring.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests().antMatchers("/test").permitAll().  anyRequest().authenticated().and().httpBasic();
//	}
	
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().anyRequest().authenticated().and().httpBasic();
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		//auth.inMemoryAuthentication().withUser("test1").password(this.passwordEncoder().encode("test123")).roles("NORMAL");
		//auth.inMemoryAuthentication().withUser("test2").password(this.passwordEncoder().encode("test123")).roles("NORMAL");
	auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
//	// @Override 
//
//	// protected void configure(HttpSecurity http) throws Exception { 
//
//	// // TODO Auto-generated method stub 
//
//	// http.authorizeRequests().anyRequest().authenticated().and().httpBasic(); 
//
//	// } 
//
//	// 
//
//	@Override 
//
//	protected void configure(HttpSecurity http) throws Exception { 
//
//	// TODO Auto-generated method stub 
//
//	http.authorizeRequests().antMatchers("/test").hasRole("normal").anyRequest().authenticated().and().httpBasic(); 
//
//	} 
//
//	 
//
//	//  
//
//	// @Override 
//
//	// protected void configure(HttpSecurity http) throws Exception { 
//
//	// // TODO Auto-generated method stub 
//
//	// http.csrf().disable().authorizeRequests().antMatchers("/test").permitAll().anyRequest().authenticated().and().httpBasic(); 
//
//	// } 
//
//	 
//
//	// @Override 
//
//	// protected void configure(HttpSecurity http) throws Exception { 
//
//	// // TODO Auto-generated method stub 
//
//	// http.authorizeRequests().antMatchers("/test/**").permitAll().anyRequest().authenticated().and().httpBasic(); 
//
//	// } 
//
//	//  
//
//	// @Override 
//
//	// protected void configure(HttpSecurity http) throws Exception { 
//
//	// // TODO Auto-generated method stub 
//
//	// http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic(); 
//
//	// } 
//
//	//  
//
//	//  
//
//	// @Override 
//
//	// protected void configure(HttpSecurity http) throws Exception { 
//
//	// // TODO Auto-generated method stub 
//
//	// http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and().authorizeRequests().anyRequest().authenticated().and().httpBasic(); 
//
//	// } 
//
//	//  
//
//	// @Override 
//
//	// protected void configure(HttpSecurity http) throws Exception { 
//
//	// // TODO Auto-generated method stub 
//
//	// http.authorizeRequests().anyRequest().permitAll().and().formLogin().loginPage("/signin"); 
//
//	// } 
//
//	@Bean 
//
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
//
//	 
//
//	{ 
//
//	  http 
//
//	  .authorizeHttpRequests() 
//
//	  .antMatchers("/test") 
//
//	  .permitAll() 
//
//	  .anyRequest() 
//
//	  .authenticated() 
//
//	  .and() 
//
//	  .httpBasic(); 
//
//	   
//
//	   DefaultSecurityFilterChain build = http.build(); 
//
//	    
//
//	   return build; 
//
//	 
//
//	} 
//
//	 
//
//	@Override 
//
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
//
//	// TODO Auto-generated method stub 
//
//	auth.inMemoryAuthentication().withUser("john").password(this.passwordEncoder().encode("john@123")).roles("NORMAL"); 
//
//	auth.inMemoryAuthentication().withUser("david").password(this.passwordEncoder().encode("david@123")).roles("ADMIN"); 
//
//	} 

}
