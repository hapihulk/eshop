package com.eshop.authservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.eshop.authservice.service.security.MongoUserDetailsService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MongoUserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
        http.requestMatchers()
        	.antMatchers("/login", "/oauth/authorize")
        	.and()
        	.authorizeRequests().anyRequest().authenticated()
            .and()
            .csrf().disable();
        // @formatter:on
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// @formatter:off
		auth.inMemoryAuthentication()
			//.passwordEncoder(NoOpPasswordEncoder.getInstance())
			.withUser("john").password("{noop}123456")
			.roles("USER");
		// @formatter:on
		/*
		 * auth.inMemoryAuthentication()
		 * .withUser("john").password(passwordEncoder().encode("123456"))
		 * .roles("USER");
		 * 
		 * auth.userDetailsService(userDetailsService)
		 * .passwordEncoder(passwordEncoder());
		 */
	}

	/*
	 * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
