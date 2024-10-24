package com.csc340.assignment5.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class to send queries and return outputs from the database
 * @author Adam Cichoski
 */
@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepo;

    /**
     * Finds all animals in the database
     * @return a list of all animals in the table
     */
    public List<Animal> getAllAnimals(){
        return animalRepo.findAll();
    }

    /**
     * Gets animals by animalId unique attribute
     * @param animalId
     * @return the animal in the table with the inputted id
     */
    public Animal getAnimalByAnimalId(int animalId){
        return animalRepo.findById(animalId).orElse(null);
    }

    /**
     * Returns the animal by the species
     * @param species
     * @return any species with matching or similar species names
     */
    public List<Animal> getAnimalBySpecies(String species){
        return animalRepo.getAnimalBySpecies(species);
    }

    /**
     * Returns the animal by the name
     * @param name
     * @return any animals with a matching or similar name
     */
    public List<Animal> getAnimalByName(String name){
        return animalRepo.getAnimalByName(name);
    }

    /**
     * Returns animals by scientific name
     * @param scientificName
     * @return all animals with a matching or similar scientificName value
     */
    public List<Animal> getAnimalByScientificName(String scientificName){
        return animalRepo.getAnimalByScientificName(scientificName);
    }

    /**
     * Returns animals by habitat
     * @param habitat
     * @return all animals with a matching or similar habitat
     */
    public List<Animal> getAnimalByHabitat(String habitat){
        return animalRepo.getAnimalByHabitat(habitat);
    }

    public List<Animal> getAnimalByDescription(String description){
        return animalRepo.getAnimalByDescription(description);
    }

    /**
     * Adds a new animal
     * @param a inputted animal to be saved to the database
     */
    public void addAnimal(Animal a){
        animalRepo.save(a);
    }

    /**
     * Updates the values of an existing animal in the database
     * @param animalId unique animal id to find the correct animal to update
     * @param animal new animal containing the desired values to update
     * If non-required attributes are left null in the new animal, they will be automatically filled in with the attributes
     * from the existing animal
     */
    public void updateAnimal(int animalId, Animal animal){
        Animal existing = getAnimalByAnimalId(animalId);
        existing.setName(animal.getName());
        existing.setScientificName(animal.getScientificName() == null? existing.getScientificName() : animal.getScientificName());
        existing.setSpecies(animal.getSpecies());
        existing.setHabitat(animal.getHabitat());
        existing.setDescription(animal.getDescription() == null? existing.getDescription() : animal.getDescription());

        animalRepo.save(existing);
    }

    /**
     * Deletes an animal from the database
     * @param animal the specific animal to be deleted
     */
    public void deleteAnimal(Animal animal){
        animalRepo.delete(animal);
    }
}

