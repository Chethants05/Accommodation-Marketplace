package com.dcl.accommodate.security.jwt;

//the class is responsible to generate tokens when requested


import com.dcl.accommodate.Config.AppEnv;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {
    //must be an encoded with Base64
    private final Key key;

    //this hedder is to fecth from .env file to application.yml then to this class
//    public JwtService (@Value("${app.jwt.secret) String secret}"){




    public JwtService(AppEnv appEnv) {
        // access nested jwt key
        this.key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(appEnv.getJwt().getKey()));
    }


    public String generateToken(Map<String, Object> claims, String subject, Duration ttl){
        var systemMillis = System.currentTimeMillis();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(systemMillis))
                .setExpiration(new Date(systemMillis+ttl.toMillis()))
                .setSubject(subject)
//                .signWith(getSignatureKey(), SignatureAlgorithm.HS256)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }


    //this method is been altered with the constructor in order to generate the secret key where secret key will not be changed every time when the key is generated
//    private Key getSignatureKey(){
//        return Keys.hmacShaKeyFor(Base64.getDecoder().decode(secret));
//    }


    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

//    parse Token

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
//                .setSigningKey(getSignatureKey())
                .setSigningKey(key)
                .build() //returns a parser to parse JWT token
                .parseClaimsJws(token)
                .getBody();
    }
}
