package com.kikopolis.resource;

import com.kikopolis.entity.Sector;
import io.smallrye.common.annotation.Blocking;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path(SectorResource.SECTOR_API_PATH)
public class SectorResource {
    protected static final String SECTOR_API_PATH = "/api/sectors";

    @Blocking
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sector> index() {
        return Sector.listAll();
    }
}
