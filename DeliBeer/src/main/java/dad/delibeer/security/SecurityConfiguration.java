package dad.delibeer.security;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dad.delibeer.repositories.UserRepositoryAuthenticationProvider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public UserRepositoryAuthenticationProvider authenticationProvider;
	
	
	@Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    	
			auth.authenticationProvider(authenticationProvider);
	    	
	    }
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
    	// Public pages
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/loginerror").permitAll();
        http.authorizeRequests().antMatchers("/logout").permitAll();
        http.authorizeRequests().antMatchers("/paginainicio").permitAll();
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