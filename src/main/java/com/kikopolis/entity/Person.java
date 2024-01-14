package com.kikopolis.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.Set;

@Entity
public class Person extends PanacheEntity {
    public static final String PERSON_SECTOR = "person_sector";
    public static final String PERSON_ID = "person_id";
    public static final String SECTOR_ID = "sector_id";
    public String name;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = PERSON_SECTOR,
            joinColumns = @JoinColumn(name = PERSON_ID, nullable = false),
            inverseJoinColumns = @JoinColumn(name = SECTOR_ID, nullable = false)
    )
    public Set<Sector> sectors;
    public boolean agreedToTerms;
    public String token;
}
