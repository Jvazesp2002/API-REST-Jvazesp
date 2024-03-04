package com.example.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepositoryI extends JpaRepository<Owner, Long>{

	public Owner findByName(final String name);

}
