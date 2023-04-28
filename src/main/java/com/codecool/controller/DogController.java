package com.codecool.controller;

import com.codecool.exception.DogIdMismatchException;
import com.codecool.exception.DogNotFoundException;
import com.codecool.model.Dog;
import com.codecool.model.DogStorage;
import com.codecool.service.DogCreator;
import com.codecool.service.DogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("dogs")
public class DogController {

    private final DogRepository dogRepository;
    private final DogStorage dogStorage;
    private final DogCreator dogCreator;

    public DogController(DogRepository dogRepository, DogStorage dogStorage, DogCreator dogCreator) {
        this.dogRepository = dogRepository;
        this.dogStorage = dogStorage;
        this.dogCreator = dogCreator;
    }

    @PostMapping("/create/random")
    public Dog createRandomDog() {
        Dog newDog = dogCreator.createRandomDog();
        dogStorage.getDogs().add(newDog);
        return dogRepository.save(newDog);
    }

    @PostMapping("/create/custom")
    public Dog createCustomDog(@RequestBody Dog dog) {
        return dogRepository.save(dog);
    }

    @GetMapping
    public List<Dog> findAll() {
        return dogRepository.findAll();
    }

    @PatchMapping("/patch/{id}")
    public ResponseEntity<?> putOrPost(@RequestBody Dog dog, @PathVariable Long id) {
        if (!Objects.equals(dog.getId(), id)) {
            throw new DogIdMismatchException("ids don't match");
        }
        String message = dogRepository.findById(id).isPresent() ? "dog updated" : "new dog created";
        dogRepository.save(dog);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOneById(@PathVariable Long id) {
        if (dogRepository.findById(id).isEmpty()) {
            throw new DogNotFoundException("dog with this id not found");
        }
        dogRepository.deleteById(id);
    }
}
