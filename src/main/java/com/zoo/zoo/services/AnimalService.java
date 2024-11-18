package com.zoo.zoo.services;
import com.zoo.zoo.entity.Animal;
import com.zoo.zoo.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal createAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal getAnimalById(Long id) {
        return animalRepository.findAnimalById(id)
                .orElseThrow(() -> new RuntimeException("Животное не найдено"));
    }

    public Animal updateAnimal(Long id, Animal newAnimal) {
        return animalRepository.findAnimalById(id).map(animal -> {
            animal.setName(newAnimal.getName());
            animal.setAge(newAnimal.getAge());
            animal.setType(newAnimal.getType());
            return animalRepository.save(animal);
        }).orElseThrow(() -> new RuntimeException("Животное не найдено"));
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }
}