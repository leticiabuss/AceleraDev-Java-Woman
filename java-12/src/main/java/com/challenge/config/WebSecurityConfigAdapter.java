package com.challenge.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.challenge.dto.UserCustomDTO;
import com.challenge.entity.User;
import com.challenge.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigAdapter extends WebSecurityConfigurerAdapter{
	
	@Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManagerBean();
    }

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository usuarioRepository) throws Exception {
	    if (usuarioRepository.count() == 0) {
	        User usuario = new User();
	        usuario.setEmail("admin@gmail.com");
	        usuario.setPassword("12345");
	        usuarioRepository.save(usuario);
	    }

	    builder.userDetailsService(email -> new UserCustomDTO(usuarioRepository.findByEmail(email)));
	}
	
	 @Bean  
	 public static NoOpPasswordEncoder passwordEncoder() {
		 return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	 }
}
