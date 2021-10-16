package com.jtmc.apps.oasis.api.v1.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.jackson.io.JacksonSerializer;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import javax.inject.Named;
import java.nio.charset.StandardCharsets;

public class LoginApiImpl implements LoginApi {

    @Inject
    private ObjectMapper objectMapper;

    @Inject
    @Named("key")
    private String secretKey;

    @Override
    public LoginResponse login() {

        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        String jws = Jwts
                .builder()
                .serializeToJsonWith(new JacksonSerializer(objectMapper))
                .setSubject("JTMC-Oasis")
                .signWith(key)
                .compact();

        LoginResponse response = new LoginResponse();
        response.setId_token(jws);
       return  response;
    }
}
