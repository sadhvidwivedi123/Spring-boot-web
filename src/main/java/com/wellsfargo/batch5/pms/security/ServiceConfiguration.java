package com.wellsfargo.batch5.pms.security;

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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
@Configuration
public class ServiceConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsServiceImpl userServiceDetailImpl;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userServiceDetailImpl).passwordEncoder(passwordEncoder());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		
		http.authorizeRequests()
		.antMatchers("/backofficeuser/**").hasAuthority("back_office_user")
		.antMatchers("/admin/**").hasAuthority("admin")
		.antMatchers("/investor/**").hasAuthority("investor");
		
		
		http.formLogin().loginPage("/validateLogin").failureUrl("/login?error=true").defaultSuccessUrl("/user_home")
		.usernameParameter("userName").passwordParameter("password");
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
		http.exceptionHandling().accessDeniedPage("/pages/access-denied-page.jsp");
		
	}
	
	
	
	
	
	

}
