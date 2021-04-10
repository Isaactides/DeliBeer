package com.example.helloworldspring;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	RepositoryUserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10, new SecureRandom());
	}
	
	@Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    	
			auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
			
		
	    	/*// Enable default password encoder (mandatory since Spring Security 5 to avoid storing passwords in plain text)
	    	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	        
	    	// User
	        auth.inMemoryAuthentication().withUser("user").password(encoder.encode("pass")).roles("USER");
	        auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("adminpass")).roles("ADMIN");
	    	*/	    	
	    }
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
    	// Public pages
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/loginerror").permitAll();
        http.authorizeRequests().antMatchers("/logout").permitAll();
        http.authorizeRequests().antMatchers("/paginainicio").permitAll();
        //http.authorizeRequests().antMatchers("/inicial").permitAll();
        http.authorizeRequests().antMatchers("/compra").permitAll();
        http.authorizeRequests().antMatchers("/comprado").permitAll();
        http.authorizeRequests().antMatchers("/agregarcomentario").permitAll();
        http.authorizeRequests().antMatchers("/ini").permitAll();
        http.authorizeRequests().antMatchers("/pedidos/pedidoaux").permitAll();
        http.authorizeRequests().antMatchers("/agregarusu").permitAll();
        http.authorizeRequests().antMatchers("/comprobacion").permitAll();
        http.authorizeRequests().antMatchers("/nuevousuario").permitAll();

        // Private pages (all other pages)
        http.authorizeRequests().antMatchers("/inicial").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/inicialadmin").hasAnyRole("ADMIN");
        http.authorizeRequests().anyRequest().authenticated();

        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/home");
        http.formLogin().failureUrl("/loginerror");

        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");
        
        // Disable CSRF at the moment
        http.csrf().disable();
    }

}