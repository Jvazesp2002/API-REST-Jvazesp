package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.persistence.Pet;
import com.example.service.OwnerServiceI;
import com.example.service.PetServiceI;

@RestController
@RequestMapping("/api/v0/pets")
public class PetController {

    private final PetServiceI service;
    private final OwnerServiceI ownerService;

    public PetController(PetServiceI service, OwnerServiceI ownerService) {
        this.service = service;
        this.ownerService = ownerService;
    }
	
	@PostMapping
	public String crearPets() {
		return "Esto es Post";
	}
	@GetMapping
	public List<Pet> devolverPets() {
		return service.getAllPets();
	}

    @PutMapping("/{id}")
    public String editPet() {
    	return "Editada";
    }
	
	@DeleteMapping("/{id}")
	public String delete() {
		return "Borrado";
	}
}
