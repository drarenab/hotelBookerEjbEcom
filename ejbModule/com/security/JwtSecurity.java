package com.security;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalAmount;
import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;


public class JwtSecurity {
	private static final String CLAIM_ID = "id";

    private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;
    private static final SecretKey SECRET_KEY = MacProvider.generateKey( SIGNATURE_ALGORITHM );
    private static final TemporalAmount TOKEN_VALIDITY = Duration.ofHours( 1L );	
	
   
    
	public String createToken( final String subject, final String loginId ) {
        final Instant now = Instant.now();
        final Date expiryDate = Date.from( now.plus( TOKEN_VALIDITY ) );
        return Jwts.builder()
                   .setSubject( subject )
                   .claim( CLAIM_ID, loginId )
                   .setExpiration( expiryDate )
                   .setIssuedAt( Date.from( now ) )
                   .signWith( SIGNATURE_ALGORITHM, SECRET_KEY )
                   .compact();
	}
	
	public String validateToken(String token) {
//		JWtVerifier j;
		
		Jws<Claims> jw=Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
		if(jw.getBody().getExpiration().before(Date.from(Instant.now()))) {//pas expirer 
			return "Token was expired";
		}
		return jw.getBody().get(CLAIM_ID).toString();//si valide on retourne l'id du client
	}
//	public void refreshToken(String token) {
//		Jws<Claims> jw=Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
//		
//		jw.getBody().setExpiration(Date.from( Instant.now().plus( TOKEN_VALIDITY )));
//		String subject=jw.getBody().getSubject();
//		String loginId=jw.getBody().get(CLAIM_ID).toString();
//		
//		Jwts.builder()
//			.setSubject(subject)
//			.claim(CLAIM_ROLE, arg1)
//	}
	
	
}
