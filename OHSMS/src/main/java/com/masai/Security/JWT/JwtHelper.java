package com.masai.Security.JWT;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtHelper {

	public final String secretKey = "harshal";

	public final String cookieName = "OHSMS";

	public final int expiration = 18000000;

	public String getTokenFromRequest(HttpServletRequest request) {
		Cookie cookie = WebUtils.getCookie(request, cookieName);
		if (cookie == null)
			return null;
		String token = cookie.getValue();
		return token;
	}

	public String getUsernameFromToken(String authToken) {
		String username = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken).getBody().getSubject();
		return username;
	}

	public String generateTokenFromUsername(String username) {
		String token = Jwts.builder().setSubject(username).setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + expiration))
				.signWith(SignatureAlgorithm.HS512, secretKey).compact();

		return token;
	}

	public ResponseCookie generateResponseCookie(String authToken) {
		ResponseCookie responseCookie = ResponseCookie.from(cookieName, authToken).path("/ohsms").maxAge(24 * 60 * 60)
				.httpOnly(true).build();
		return responseCookie;
	}

	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
			return true;
		} catch (IllegalArgumentException e) {

		} catch (SignatureException e) {

		} catch (ExpiredJwtException e) {

		} catch (MalformedJwtException e) {

		} catch (UnsupportedJwtException e) {

		}

		return false;
	}
}
