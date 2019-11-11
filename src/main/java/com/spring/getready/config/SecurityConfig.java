package com.spring.getready.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.getready.interceptor.AuthSuccessHandler;
import com.spring.getready.services.CustomAuthProvider;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthProvider authProvider;

	@Autowired
	private AuthSuccessHandler successHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder().encode("user1")).roles("USER").and()
//				.withUser("admin").password(passwordEncoder().encode("admin")).roles("admin");
		auth.authenticationProvider(authProvider);
	}

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/public/**");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/home/**").hasRole("USER").antMatchers("/admin/**").hasRole("ADMIN").and()
				.formLogin().loginPage("/login").successHandler(successHandler).permitAll().and().logout()
				.clearAuthentication(true).invalidateHttpSession(true).deleteCookies("JSESSIONID").permitAll();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
