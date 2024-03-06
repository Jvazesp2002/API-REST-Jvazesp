package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.persistence.Pet;

public interface PetServiceI {

	public void createPet(Pet p);
	public void deletePet(Long id);
	public void updatePet(Long id, Pet updated);
	public List<Pet> getAllPets();
	public Pet getPetByName(String name);
	public Pet getPetById(Long id);
}
