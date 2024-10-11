package com.csc340.assignment4.animal;

import jakarta.persistence.*;

/**
 * Class to store column information for animal table
 * @author Adam Cichoski
 */
@Entity
@Table(name= "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int animalId;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String species;

    @Column(nullable=false)
    private String habitat;

    @Column
    private String scientificName;

    @Column
    private String description;

    /**
     * Constructor to fill in all values
     * @param animalId
     * @param name
     * @param species
     * @param habitat
     * @param scientificName
     * @param description
     */
    public Animal(int animalId, String name, String species, String habitat, String scientificName, String description){
        this.animalId = animalId;
        this.name = name;
        this.species = species;
        this.habitat = habitat;
        this.scientificName = scientificName;
        this.description = description;
    }

    /**
     * Constructor to fill in only required attributes that are not automatically filled
     * @param name
     * @param species
     * @param habitat
     */
    public Animal(String name, String species, String habitat){
        this.name = name;
        this.species = species;
        this.habitat = habitat;
    }

    /**
     * Default constructor
     */
    public Animal(){

    }

    public int getAnimalId() {
        return animalId;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getDescription() {
        return description;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
