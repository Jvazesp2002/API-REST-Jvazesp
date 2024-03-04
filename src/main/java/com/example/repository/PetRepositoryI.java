package com.example.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepositoryI extends JpaRepository<Pet, Long>{

	public Pet findByName(final String name);
}
