package com.example.EMS.EMS.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    // Use @Value annotation to inject the environment variable into this field
    @Value("${jwt.secret}")
    private String secretKey; // Now it will get the value from the environment variable

    // Method to generate a JWT token
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Token valid for 1 day
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // Method to validate JWT token
    public boolean validateToken(String token, String username) {
        String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    // Method to extract username from JWT
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // Method to check if the token is expired
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Method to extract expiration date from JWT
    public Date extractExpiration(String token) {
        return extractClaims(token).getExpiration();
    }

    // Method to extract claims from JWT (helper method)
    private Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)  // Set secret key
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
