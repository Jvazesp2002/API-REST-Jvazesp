package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.persistence.Pet;

public interface PetRepositoryI extends JpaRepository<Pet, Long>{

	public Pet findByName(final String name);
}
