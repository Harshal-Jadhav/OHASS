package com.masai.Security.JWT;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.masai.Services.CustomUserDetailsServiceImpl;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtHelper helper;

	@Autowired
	private CustomUserDetailsServiceImpl userDetailsServiceImpl;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// logic of how to filter requests containing jwt token
		try {
			String jwt = helper.getTokenFromRequest(request);
			if (jwt != null) {
				if (helper.validateToken(jwt)) {
					String username = helper.getUsernameFromToken(jwt);
					UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);

					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		} catch (Exception e) {
			System.out.println("Could not set the authentication");
		}

		filterChain.doFilter(request, response);
	}
}
