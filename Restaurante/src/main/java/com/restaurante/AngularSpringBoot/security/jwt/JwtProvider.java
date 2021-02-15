package com.restaurante.AngularSpringBoot.security.jwt;


import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.restaurante.AngularSpringBoot.security.entity.UserMain;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtProvider {
	
	
	
	private String secret="miSecreto";
	
	private int expiration=5*30*50;
	
	
	public String generateToken(Authentication authentication) {
		UserMain userMain = (UserMain) authentication.getPrincipal();
		return Jwts.builder().setSubject(userMain.getUsername()).setExpiration(new Date(new Date().getTime()+expiration*1000)).signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	public String getEmailFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (MalformedJwtException e) {
			System.out.println("Token malformed");
		} catch (UnsupportedJwtException e) {
			System.out.println("Token not supported");
		} catch (ExpiredJwtException e) {
			System.out.println("Token expired");
		} catch (IllegalArgumentException e) {
			System.out.println("Token empty");
		}catch (SignatureException e) {
			System.out.println("Token not signed");
		}
		return false;
	}
	
}
