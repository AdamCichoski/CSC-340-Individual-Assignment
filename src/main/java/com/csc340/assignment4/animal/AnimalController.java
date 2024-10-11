package com.csc340.assignment4.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for mapping, creating, and updating animal objects in the database
 * @author Adam Cichoski
 */
@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    /**
     * Returns all animals
     * localhost:8080/animal/all
     * @return
     */
    @GetMapping("/all")
    public List<Animal> getAllAnimals(){
        return animalService.getAllAnimals();
    }

    /**
     * Returns a single animal by finding its animalId
     * localhost:8080/animal/{animalId}
     * Example: localhost:8080/animal/8888 returns a pig
     * @param animalId unique animal id to find specific animal
     * @return animal with matching animalId
     */
    @GetMapping("/{animalId}")
    public Animal getAnimalByID(@PathVariable int animalId){
        return animalService.getAnimalByAnimalId(animalId);
    }

    /**
     * Returns animals by matching the name
     * localhost:8080/animal?name=temp
     * Example: localhost:8080/animal/name?name=Josh returns all animals named Josh
     * @param name name to match
     * @return list of animals containing the name string
     */
    @GetMapping("")
    public List<Animal> getAnimalByName(@RequestParam(name="name", defaultValue = "pig") String name){
        return animalService.getAnimalByName(name);
    }

    /**
     *
     * localhost:8080/animal/species?species=temp
     * Example: localhost:8080/animal/species?species=horse returns all horses
     * @param species species to match
     * @return list of animals
     */
    @GetMapping("/species")
    public List<Animal> getAnimalBySpecies(@RequestParam String species){
        return animalService.getAnimalBySpecies(species);
    }

    /**
     * Returns all animals with similar or matching scientific names to input value
     * localhost:8080/animal/scientificName?scientificName=temp
     * @param scientificName  scientific name to match
     * @return list of animals
     */
    @GetMapping("/scientificName")
    public List<Animal> getAnimalByScientificName(@RequestParam String scientificName){
        return animalService.getAnimalByScientificName(scientificName);
    }

    /**
     * Returns all animals with similar or matching habitat name to input value
     * localhost:8080/animal/habitat?habitat=temp
     * @param habitat habitat string to match
     * @return all animals containing habitat string
     */
    @GetMapping("/habitat")
    public List<Animal> getAnimalByHabitat(@RequestParam String habitat){
        return animalService.getAnimalByHabitat(habitat);
    }

    /**
     * Get mapping to all animals containing the description string
     * @param description description to match
     * @return all animals containing the description
     */
    @GetMapping("/description")
    public List<Animal> getAnimalByDescription(@RequestParam String description){
        return animalService.getAnimalByDescription(description);
    }

    /**
     * Posts a new animal into the database
     * localhost:8080/animal/new
     * Example Body:
     * {
     *     "animalId": 1,
     *     "name": "temp",
     *     "species": "temp",
     *     "habitat": "temp",
     *     "scientificName": "temp",
     *     "description":"temp"
     * }
     * @param a new animal to be added
     * @return list of animals
     */
    @PostMapping("/new")
    public List<Animal> addAnimal(@RequestBody Animal a){
        animalService.addAnimal(a);
        return animalService.getAllAnimals();
    }


    /**
     * Method to update the values of an animal
     * localhost:8080/animal/update/{animalId}
     * Example Body:
     * {
     *     "animalId": 1,
     *     "name": "temp",
     *     "species": "temp",
     *     "habitat": "temp",
     *     "scientificName": "temp",
     *     "description":"temp"
     * }
     * If non-required values are left null, they will be filled in with currently used values
     * @param animalId unique animal id to find the right one to update
     * @param animal new animal with updated values
     * @return the animal updated
     */
    @PutMapping("/update/{animalId}")
    public Animal updateAnimal(@PathVariable int animalId, @RequestBody Animal animal){
        animalService.updateAnimal(animalId, animal);
        return animalService.getAnimalByAnimalId(animalId);
    }

    /**
     * Delete mapping. Deletes the individual animal based on inputted unique animal id value
     * localhost:8080/animal/delete/{animalId}
     * @param animalId unique animal id to find the right animal to delete
     * @return list of animals
     */
    @DeleteMapping("delete/{animalId}")
    public List<Animal> deleteAnimal(@PathVariable int animalId){
        animalService.deleteAnimal(getAnimalByID(animalId));
        return animalService.getAllAnimals();
    }

}
