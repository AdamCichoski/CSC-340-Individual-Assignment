package com.csc340.assignment4.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepo;

    /**
     * Finds all animals in the database
     * @return
     */
    public List<Animal> getAllAnimals(){
        return animalRepo.findAll();
    }

    /**
     * Gets animals by animalId unique attribute
     * @param animalId
     * @return
     */
    public Animal getAnimalByAnimalId(int animalId){
        return animalRepo.findById(animalId).orElse(null);
    }

    /**
     * Returns the animal by the species
     * @param species
     * @return
     */
    public List<Animal> getAnimalBySpecies(String species){
        return animalRepo.getAnimalBySpecies(species);
    }

    /**
     * Returns the animal by the name
     * @param name
     * @return
     */
    public List<Animal> getAnimalByName(String name){
        return animalRepo.getAnimalByName(name);
    }

    /**
     * Adds a new animal
     * @param a
     */
    public void addAnimal(Animal a){
        animalRepo.save(a);
    }

    /**
     *
     * @param animalId
     * @param animal
     */
    public void updateAnimal(int animalId, Animal animal){
        Animal existing = getAnimalByAnimalId(animalId);
        existing.setName(animal.getName());
        existing.setScientificName(animal.getScientificName() == null? existing.getScientificName() : animal.getScientificName());
        existing.setSpecies(animal.getSpecies());
        existing.setHabitat(animal.getHabitat());
        existing.setDescription(animal.getDescription() == null? existing.getDescription() : animal.getDescription());

        animalRepo.save(animal);
    }
}

