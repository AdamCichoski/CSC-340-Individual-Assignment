package com.csc340.assignment4.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * @param animalId
     * @return
     */
    @GetMapping("/{animalId}")
    public Animal getAnimalByID(@PathVariable int animalId){
        return animalService.getAnimalByAnimalId(animalId);
    }

    /**
     * Returns animals by matching the name
     * localhost:8080/animal/name?name=temp
     * Example: localhost:8080/animal/name?name=Josh returns all animals named Josh
     * @param name
     * @return
     */
    @GetMapping("/name")
    public List<Animal> getAnimalByName(@RequestParam(name="name", defaultValue = "pig") String name){
        return animalService.getAnimalByName(name);
    }

    /**
     *
     * localhost:8080/animal/species?species=temp
     * Example: localhost:8080/animal/species?species=horse returns all horses
     * @param species
     * @return
     */
    @GetMapping("/species")
    public List<Animal> getAnimalBySpecies(@RequestParam String species){
        return animalService.getAnimalBySpecies(species);
    }

    /**
     * Posts a new animal into the database
     * localhost:8080/animal/new
     * @param a
     * @return
     */
    @PostMapping("/new")
    public List<Animal> addAnimal(@RequestBody Animal a){
        animalService.addAnimal(a);
        return animalService.getAllAnimals();
    }


    @PutMapping("/update/{animalId}")
    public Animal updateAnimal(@PathVariable int animalId, @RequestBody Animal animal){
        animalService.updateAnimal(animalId, animal);
        return animalService.getAnimalByAnimalId(animalId);
    }
}
