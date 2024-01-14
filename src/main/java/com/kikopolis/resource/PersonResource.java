package com.kikopolis.resource;

import com.kikopolis.entity.Person;
import com.kikopolis.exception.ValidationException;
import com.kikopolis.service.PersonService;
import io.smallrye.common.annotation.Blocking;
import jakarta.annotation.Nonnull;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path(PersonResource.PERSON_API_PATH)
public class PersonResource {
    protected static final String PERSON_API_PATH = "/api/persons";
    @Inject
    PersonService personService;

    @Transactional
    @Blocking
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Person create(Person person, @Nonnull @HeaderParam("X-TOKEN") String token) {
        try {
            return personService.save(person, token);
        } catch (ValidationException e) {
            throw new BadRequestException("Please check your request body and try again.");
        }
    }

    @Blocking
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person person(@HeaderParam("X-TOKEN") String token) {
        return Person.find("token", token).firstResult();
    }
}
