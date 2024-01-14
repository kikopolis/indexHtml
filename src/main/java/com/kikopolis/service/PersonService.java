package com.kikopolis.service;

import com.kikopolis.entity.Person;
import com.kikopolis.exception.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class PersonService {
    @Inject
    EntityManager em;

    public Person save(final Person person, final String token) {
        if (personIsInvalid(person)) {
            throw new ValidationException();
        }
        final Person existingPerson = Person.find("token", token).firstResult();
        if (existingPerson == null) {
            person.token = token;
            person.persist();
            return person;
        }
        existingPerson.name = person.name;
        existingPerson.sectors = person.sectors;
        existingPerson.agreedToTerms = person.agreedToTerms;
        em.flush();
        return existingPerson;
    }

    private static boolean personIsInvalid(final Person person) {
        return person.name == null
                || person.name.isBlank()
                || !person.agreedToTerms
                || person.sectors == null
                || person.sectors.isEmpty();
    }
}
