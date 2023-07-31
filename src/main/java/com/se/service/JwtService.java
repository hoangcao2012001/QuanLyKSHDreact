package com.se.service;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.se.entity.Customer;

import net.minidev.json.JSONObject;

@Service
public class JwtService {
	@Autowired 
	private Environment evn;
	public static final String USERNAME = "username";
	private byte[] generateShareSecret() {
		byte[] shareSecret = new byte[32];
		String secret_key = evn.getProperty("secret_key");
		shareSecret = secret_key.getBytes();
		return shareSecret;
	}
	 public Date generateExpirationDate() {
		 int expire_time = Integer.parseInt(evn.getProperty("expire_time"));
	        return new Date(System.currentTimeMillis() + expire_time);
	    }
	public String generateToken(String username) {
        String token = null;
        try {
            JWSSigner signer = new MACSigner(generateShareSecret());
            
            JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder();
            builder.claim(USERNAME, username);
            builder.expirationTime(generateExpirationDate());
            JWTClaimsSet claimsSet = builder.build();
            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
            signedJWT.sign(signer);

            token = signedJWT.serialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }
	 private JWTClaimsSet getClaimsFromToken(String token) {
	        JWTClaimsSet claims = null;
	        try {
	            SignedJWT signedJWT = SignedJWT.parse(token);
	            JWSVerifier verifier = new MACVerifier(generateShareSecret());
	            if (signedJWT.verify(verifier)) {
	                claims = signedJWT.getJWTClaimsSet();
	            }
	        } catch (ParseException | JOSEException e) {
	           e.printStackTrace();
	        }
	        return claims;
	    }
	 private Date getExpirationDateFromToken(String token) {
		 Date expiration = null;
		 JWTClaimsSet claim = getClaimsFromToken(token);
		 expiration = claim.getExpirationTime();
		 return expiration;
		 
	    }
	 public String getUserFromToken(String token) {
	    	String username = null;
	         try {
	             JWTClaimsSet claims = getClaimsFromToken(token);
	             username = claims.getStringClaim(USERNAME);
	         } catch (Exception e) {
	             e.printStackTrace();
	         }
	         return username;
	    }
	  //--------------------isTokenExpired-------------------------
	    private boolean isTokenExpired(String token) {
	    	Date expiration = getExpirationDateFromToken(token);
	    	return expiration.before(new Date());
	    }
	  public Boolean validateTokenLogin(String token) {
		if (token == null || token.trim().length() == 0) {
			return false;
		}
		String username = getUserFromToken(token);
		if (username == null || username.isEmpty()) {
			return false;
		}
		if (isTokenExpired(token)) {
			return false;
		}
		return true;
	}
}
