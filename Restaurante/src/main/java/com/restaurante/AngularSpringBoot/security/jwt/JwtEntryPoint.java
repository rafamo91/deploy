package com.restaurante.AngularSpringBoot.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint{
	

	@Override
	public void commence(HttpServletRequest req, HttpServletResponse resp,
			AuthenticationException authException) throws IOException, ServletException {
		resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No authorized");
	}
	
	

}
