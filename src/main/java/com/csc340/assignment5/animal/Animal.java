package com.csc340.assignment5.animal;

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
    private int animal_id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String species;

    @Column(nullable=false)
    private String habitat;

    @Column
    private String scientific_name;

    @Column
    private String description;

    /**
     * Constructor to fill in all values
     * @param animal_id
     * @param name
     * @param species
     * @param habitat
     * @param scientific_name
     * @param description
     */
    public Animal(int animal_id, String name, String species, String habitat, String scientific_name, String description){
        this.animal_id = animal_id;
        this.name = name;
        this.species = species;
        this.habitat = habitat;
        this.scientific_name = scientific_name;
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
        return animal_id;
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
        return scientific_name;
    }

    public String getDescription() {
        return description;
    }

    public void setAnimalId(int animal_id) {
        this.animal_id = animal_id;
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

    public void setScientificName(String scientific_name) {
        this.scientific_name = scientific_name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
