package com.spring.restful.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	 @Autowired
	 private UserDetailsService  userDetailsService;
	 
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/* auth.inMemoryAuthentication()
		 .withUser("murali").password("kodavati").authorities("USER").and()
		 .withUser("krishna").password("kodavati").authorities("ADMIN");*/
		 auth
		 .userDetailsService(userDetailsService)
		 .passwordEncoder(passwordEncoder());
	 }
	 
	 @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.authorizeRequests()
               	//.antMatchers("**/employee/**").hasAnyAuthority("ADMIN")
                .anyRequest().fullyAuthenticated()
                .and()
                .httpBasic();
    }

}