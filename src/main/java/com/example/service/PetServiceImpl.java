package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.persistence.Pet;
import com.example.persistence.PetRepositoryI;

@Service
public class PetServiceImpl implements PetServiceI {

	private final PetRepositoryI petRepo;

	public PetServiceImpl(PetRepositoryI petRepo) {
		this.petRepo = petRepo;
	}

	@Override
	public void createPet(Pet p) {

		petRepo.save(p);
	}

	@Override
	public void deletePet(Long id) {

		petRepo.deleteById(id);
	}

	@Override
	public void updatePet(Long id, Pet updated) {
		Pet existing = petRepo.findById(id).orElse(null);

		if (existing != null) {
			existing.setName(updated.getName());
			existing.setType(updated.getType());
			existing.setHunger(updated.getHunger());
			existing.setHappiness(updated.getHappiness());
		}
	}

	@Override
	public List<Pet> getAllPets() {
		return petRepo.findAll();
	}

	@Override
	public Pet getPetByName(String name) {
		return petRepo.findByName(name);
	}

	@Override
	public Pet getPetById(Long id) {
		Optional<Pet> existingPet = petRepo.findById(id);
		if (existingPet.isPresent()) {
			return existingPet.get();
		} else {
			return null;
		}
	}

}
