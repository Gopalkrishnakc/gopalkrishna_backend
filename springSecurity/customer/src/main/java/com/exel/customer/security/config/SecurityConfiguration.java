package com.exel.customer.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.exel.customer.jwt.filter.JwtAuthFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Autowired
	DataSource dataSource;
	   @Autowired
	    private JwtAuthFilter authFilter;
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/Admin/admin","/api/authenticate").permitAll())
                .authorizeHttpRequests(requests -> requests.requestMatchers("/api/customer/**")
                        .authenticated())
                .sessionManagement(management -> management
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class).build();

    }                                                                                                                                                                                                         
	  
		@Bean
	    public UserDetailsService userDetailsService() {
//			UserDetails user1=User.withUsername("user1")
//					.password(encoder.encode("password1")).roles("USER").build();
//			
//			UserDetails admin=User.withUsername("admin")
//					.password(encoder.encode("adminpass")).roles("ADMIN").build();
//			JdbcUserDetailsManager userDetailsManager=new JdbcUserDetailsManager(dataSource);
//			userDetailsManager.createUser(user1);
//			userDetailsManager.createUser(admin);
//			return userDetailsManager;
			return new CustomerInfoDetailsService();
			
		}
		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
			
		}
		@Bean
		public AuthenticationProvider authenticationProvider() {
			DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
			authenticationProvider.setUserDetailsService(userDetailsService());
			authenticationProvider.setPasswordEncoder(passwordEncoder());
			return authenticationProvider;
		}

	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
	        return config.getAuthenticationManager();
	    }
	}


