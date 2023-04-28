package com.codecool.service;

import com.codecool.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DogRepository extends JpaRepository<Dog, Long> {
}
