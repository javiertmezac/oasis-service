package com.jtmc.apps.oasis.api.v1.healthcheck;

import com.google.inject.Inject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

import javax.crypto.SecretKey;
import javax.inject.Named;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.nio.charset.StandardCharsets;

public class HealthcheckApiImpl implements HealthcheckApi {

    @Inject
    @Named("key")
    private String secretKey;


    @Override
    public Response getStatus() {
        return Response.ok().entity("all chido compa!").build();
    }

    @Override
    public Response tryAuth() {
        return Response.accepted().build();
    }
}
