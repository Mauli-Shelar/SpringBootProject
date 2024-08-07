package org.com.config;


import org.com.FilterClass;
import org.com.service.LoginUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MyAppSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	LoginUserDetailService loginUserDetailService;
	
	@Autowired
	FilterClass filter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
     
		http
		.csrf().disable()
		   .authorizeRequests()
		   .antMatchers("/v1/user/signup").permitAll()
		   .antMatchers("/token").permitAll()
		   .anyRequest()
		   .authenticated()
		   .and()
		   .httpBasic();
		
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		
	}
	
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(loginUserDetailService);
	}




	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder(10);
	}
	
	@Bean
	public AuthenticationManager authenticationManager() throws Exception
	{
		return super.authenticationManager();
	}

	

}
