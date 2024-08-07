package com.exel.customer.jwt.filter;

import static com.exel.customer.constants.CustomerConstants.TOKEN_NOT_VALIDATED_OR_TOKEN_EXPIRED;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.exel.customer.exception.CustomerNotFoundException;
import com.exel.customer.security.config.CustomerInfoDetailsService;
import com.exel.customer.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

	@Autowired
	private JwtService jwtService;

	@Autowired
	CustomerInfoDetailsService customerInfoDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String authHeader = request.getHeader("Authorization");
		System.out.println("filter JWT Auth " + authHeader);
		String token = null;
		String username = null;
		if (authHeader != null && authHeader.startsWith("Bearer")) {
			token = authHeader.substring(7);
			username = jwtService.extractUsername(token);
		}
			
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = customerInfoDetailsService.loadUserByUsername(username);
			if (jwtService.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				System.out.println("This is authenticationToken " + authenticationToken);
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
			else {
				throw new CustomerNotFoundException(TOKEN_NOT_VALIDATED_OR_TOKEN_EXPIRED);
			}

		}

		filterChain.doFilter(request, response);
	}

}