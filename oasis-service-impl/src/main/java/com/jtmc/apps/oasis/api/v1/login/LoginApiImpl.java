package com.jtmc.apps.oasis.api.v1.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.jtmc.apps.oasis.application.users.UserAppImpl;
import com.jtmc.apps.oasis.domain.Users;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.jackson.io.JacksonSerializer;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import javax.inject.Named;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class LoginApiImpl implements LoginApi {

    @Inject
    private ObjectMapper objectMapper;

    @Inject
    @Named("key")
    private String secretKey;

    @Inject
    private UserAppImpl userApp;

    @Override
    public LoginResponse login(String email, String password) {
        Optional<Users> user = userApp.selectUser(email, password);
        if (!user.isPresent()) {
            System.out.println("User Not Found");
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }

        String jws = buildJWS(user.get().getName());

        LoginResponse response = new LoginResponse();
        response.setId_token(jws);
       return  response;
    }

    private String buildJWS(String user){
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        return Jwts
                .builder()
                .serializeToJsonWith(new JacksonSerializer(objectMapper))
                .setSubject(user)
                .signWith(key)
                .compact();
    }
}
