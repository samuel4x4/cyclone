package com.ruby.cyclone.configserver.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil {

    @Value("&{jwt.secret}")
    private String secret;

    @Value("#{new Long('${jwt.token.validity}')}")
    private Long tokenValidity;

    public String getTokenUsername(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }

    public Date getTokenExpirationDate(String token) {
        return getAllClaimsFromToken(token).getExpiration();
    }

    public boolean isTokenExpired(String token) {
        Date tokenExpirationDate = getTokenExpirationDate(token);
        return tokenExpirationDate.before(new Date());
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public String generateToken(Map<String, Object> claims, String subject) {
        long now = Time.now();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + tokenValidity))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return generateToken(claims, userDetails.getUsername());
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String username = getTokenUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

}
