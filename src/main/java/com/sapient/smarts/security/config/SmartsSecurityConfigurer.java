package com.sapient.smarts.security.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Security configuration file
 * 
 * @author vbha12
 *
 */

public class SmartsSecurityConfigurer extends WebSecurityConfigurerAdapter{
	


	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
	}

	/**
	 * Sets the custom Authentication provider to be used for the authentication
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
	}

	@Override
	protected AuthenticationManager authenticationManager() throws Exception
	{
		return null;
	}




}
