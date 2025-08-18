package com.abdur.BillingSoftware.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Component
public class JwtUtil {

    @Value("${jwt.secret.key}")
    private String SECRET_KEY;

    public String generateToken(UserDetails userDetails){
        Map<String , Object> claims = new HashMap<>();  // role if the user is get here
        return createToken(claims,userDetails.getUsername());
    }

    private String createToken(Map<String,Object> claims,String subject){
        return Jwts.builder()
                .setClaims(claims)  // whole JWT PAYLOADS (SUBJECT , EXP , ISSUED AT , ROLE(CUSTOM CLAIM ) All these are Claims
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) //10 hours expirations
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token){
        return extraClaim(token, Claims::getSubject); // claim->claim.getSubject
    }

    public Date extractExpiration(String token){
        return extraClaim(token,Claims::getExpiration);  // claim->claim.getSubject
    }

    public <T> T extraClaim(String token , Function<Claims,T> claimsResolver){ // here the claimResolver is treated as claim->claim.getSubject
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token , UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && ! isTokenExpired(token));
    }
}
