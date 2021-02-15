package com.restaurante.AngularSpringBoot.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.restaurante.AngularSpringBoot.security.service.UserDetailsServiceImpl;

public class JwtTokenFilter extends OncePerRequestFilter{
	
	

	@Autowired
	JwtProvider jwtProvider;
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String token = getToken(req);

			if(token != null && jwtProvider.validateToken(token)) {
				String email = jwtProvider.getEmailFromToken(token);
				UserDetails userDetails = userDetailsService.loadUserByUsername(email);
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		} catch (Exception e) {
			System.out.println("Failed method doFilter");
		}
		filterChain.doFilter(req, resp);
	}
	
	private String getToken(HttpServletRequest req) {
		String header = req.getHeader("Authorization");
		System.out.println(header);
		if(header != null && header.startsWith("Bearer")) {
			return header.replace("Bearer ", "");
		}else {
			return null;
		}
	}

}
