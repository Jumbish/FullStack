package com.springboot.blog.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.springboot.blog.exception.BlogApiException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {

	@Value("${app.jwt-secret}")
	private String jwtSecret;

	@Value("${app-jwt-expiration-milliseconds}")
	private long jwtExpirationDate;

//	Generating token
	public String generateToken(Authentication authentication) {
		String username = authentication.getName();

		Date currentDate = new Date();

		Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

		String jwtToken = Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(expireDate)
				.signWith(key()).compact();

		return jwtToken;
	}

	private Key key() {
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
	}

	// get username from the jwttoken

	public String getUsername(String token) {

		Claims claims = Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(token).getBody();
		String username = claims.getSubject();
		return username;
	}
	
	//validate the jwttoken
	
	public boolean validateToekn(String token) {
		try{
			Jwts.parserBuilder().setSigningKey(key()).build().parse(token);
		}catch (Exception e) {
			throw new BlogApiException(HttpStatus.BAD_REQUEST, "EXPIRED jwt token");
		}
		return true;
	}
}
