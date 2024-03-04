package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.persistence.Owner;

public interface OwnerRepositoryI extends JpaRepository<Owner, Long>{

	public Owner findByName(final String name);

}
