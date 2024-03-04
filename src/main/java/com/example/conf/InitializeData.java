package com.example.conf;

import com.example.persistence.Owner;
import com.example.persistence.Pet;
import com.example.service.OwnerServiceI;
import com.example.service.PetServiceI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitializeData implements CommandLineRunner {

    private final OwnerServiceI ownerService;
    private final PetServiceI petService;

    public InitializeData(OwnerServiceI ownerService, PetServiceI petService) {
        this.ownerService = ownerService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Crear un Owner
        Owner owner = new Owner();
        owner.setName("John Doe");
        owner.setEmail("john.doe@example.com");

        // Crear una lista de Pets
        List<Pet> pets = new ArrayList<>();

        Pet pet1 = new Pet();
        pet1.setName("Fluffy");
        pet1.setType("Dog");
        pet1.setHappiness(10);
        pet1.setHunger(5);
        pet1.setOwner(owner);

        Pet pet2 = new Pet();
        pet2.setName("Whiskers");
        pet2.setType("Cat");
        pet2.setHappiness(8);
        pet2.setHunger(3);
        pet2.setOwner(owner);

        pets.add(pet1);
        pets.add(pet2);

        // Asignar la lista de Pets al Owner
        owner.setPets(pets);

        // Guardar el Owner y sus Pets utilizando los servicios correspondientes
        ownerService.createOwner(owner);

        for (Pet pet : pets) {
            petService.createPet(pet);
        }

        // Puedes agregar más operaciones de prueba según sea necesario
    }
}
