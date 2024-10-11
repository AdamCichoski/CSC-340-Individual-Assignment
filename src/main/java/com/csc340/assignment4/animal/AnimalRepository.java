package com.csc340.assignment4.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository to store queries for animals
 * @author Adam Cichoski
 */
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    /**
     * Query to match species
     * Matches to any species containing the values in the species parameter
     * @param species
     * @return
     */
    @Query(value ="SELECT * FROM animal WHERE species LIKE %:species%", nativeQuery = true)
    List<Animal> getAnimalBySpecies(String species);

    /**
     * Query to match by name
     * Matches to any name containing the values in the name parameter
     * @param name
     * @return
     */
    @Query(value= "SELECT * FROM animal WHERE name LIKE %:name%", nativeQuery = true)
    List<Animal> getAnimalByName(String name);


    /**
     * Query to match by scientific name
     * @param scientificName
     * @return
     */
    @Query(value = "SELECT * FROM animal WHERE scientificName LIKE %:scientificName%", nativeQuery = true)
    List<Animal> getAnimalByScientificName(String scientificName);

    /**
     * Query to extract animals by habitat
     * @param habitat
     * @return
     */
    @Query(value = "SELECT * FROM animal WHERE habitat LIKE %:habitat%",nativeQuery = true)
    List<Animal> getAnimalByHabitat(String habitat);

    /**
     * Query to extract animals based on description
     * @param description
     * @return
     */
    @Query(value = "SELECT * FROM animal WHERE description LIKE %:description%", nativeQuery = true)
    List<Animal> getAnimalByDescription(String description);
}
