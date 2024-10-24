package com.csc340.assignment5.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Controller for mapping, creating, and updating animal objects in the database
 * @author Adam Cichoski
 */
@Controller
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
    public String getAllAnimals(Model model){
        model.addAttribute("animalList", animalService.getAllAnimals());
        return "animal-list";
    }

    /**
     * Returns a single animal by finding its animalId
     * localhost:8080/animal/{animalId}
     * Example: localhost:8080/animal/8888 returns a pig
     * @param animalId unique animal id to find specific animal
     * @return animal with matching animalId
     */
    @GetMapping("/{animalId}")
    public String getAnimalByID(@PathVariable int animalId, Model model){
        model.addAttribute("animal", animalService.getAnimalByAnimalId(animalId));
        return "animal-details";
    }

    /**
     * Returns animals by matching the name
     * localhost:8080/animal?name=temp
     * Example: localhost:8080/animal/name?name=Josh returns all animals named Josh
     * @param name name to match
     * @return list of animals containing the name string
     */
    @GetMapping("")
    public String getAnimalByName(@RequestParam(name="name", defaultValue = "pig") String name, Model model){
        model.addAttribute("animalList", animalService.getAnimalByName(name));
        return "animal-list";
    }

    /**
     *
     * localhost:8080/animal/species?species=temp
     * Example: localhost:8080/animal/species?species=horse returns all horses
     * @param species species to match
     * @return list of animals
     */
    @GetMapping("/species")
    public String getAnimalBySpecies(@RequestParam String species, Model model){
        model.addAttribute("animalList", animalService.getAnimalBySpecies(species));
        return "animal-list";
    }

    /**
     *
     * @return
     */
    @GetMapping("details")
    public String animalDetails(){
        return "animal-details";
    }

    /**
     * Returns all animals with similar or matching scientific names to input value
     * localhost:8080/animal/scientificName?scientificName=temp
     * @param scientificName  scientific name to match
     * @return list of animals
     */
    @GetMapping("/scientificName")
    public String getAnimalByScientificName(@RequestParam String scientificName, Model model){
        model.addAttribute("animalList", animalService.getAnimalByScientificName(scientificName));
        return "animal-list";
    }

    /**
     * Returns all animals with similar or matching habitat name to input value
     * localhost:8080/animal/habitat?habitat=temp
     * @param habitat habitat string to match
     * @return all animals containing habitat string
     */
    @GetMapping("/habitat")
    public String getAnimalByHabitat(@RequestParam String habitat, Model model){
        model.addAttribute("animalList", animalService.getAnimalByHabitat(habitat));
        return "animal-list";
    }

    /**
     * Get mapping to all animals containing the description string
     * @param description description to match
     * @return all animals containing the description
     */
    @GetMapping("/description")
    public String getAnimalByDescription(@RequestParam String description, Model model){
        model.addAttribute("animalList", animalService.getAnimalByDescription(description));
        return "animal-list";
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
    public String addAnimal(Animal a){
        animalService.addAnimal(a);
        return "redirect:/animal/all";
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
     * @param animal new animal with updated values
     * @return the animal updated
     */
    @PostMapping("/update")
    public String updateAnimal(Animal animal){
        animalService.addAnimal(animal);
        return "redirect:/animal/" + animal.getAnimalId();
    }

    /**
     * Delete mapping. Deletes the individual animal based on inputted unique animal id value
     * localhost:8080/animal/delete/{animalId}
     * @param animalId unique animal id to find the right animal to delete
     * @return list of animals
     */
    @GetMapping("delete/{animalId}")
    public String deleteAnimal(@PathVariable int animalId){
        animalService.deleteAnimal(animalService.getAnimalByAnimalId(animalId));
        return "redirect:/animal/all";
    }

    /**
     *
     * @return
     */
    @GetMapping("/create")
    public String createAnimal(){
        return "animal-create";
    }

    /**
     *
     * @param animalId
     * @param model
     * @return
     */
    @GetMapping("/update-form/{animalId}")
    public String updateForm(@PathVariable int animalId, Model model){
        model.addAttribute("animal", animalService.getAnimalByAnimalId(animalId));
        return "animal-update";
    }

}
