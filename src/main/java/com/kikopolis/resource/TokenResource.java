package com.kikopolis.resource;

import com.kikopolis.service.TokenService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path(TokenResource.TOKEN_API_PATH)
public class TokenResource {
    protected static final String TOKEN_API_PATH = "/api/tokens";
    @Inject
    TokenService tokenService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String index() {
        return String.format("{\"token\": \"%s\"}", tokenService.token());
    }
}
