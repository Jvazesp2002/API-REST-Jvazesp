package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.persistence.Owner;
import com.example.persistence.OwnerRepositoryI;

@Service
public class OwnerServiceImpl implements OwnerServiceI {

	private final OwnerRepositoryI ownerRepo;

	@Autowired
	public OwnerServiceImpl(OwnerRepositoryI ownerRepo) {
		this.ownerRepo = ownerRepo;
	}

	@Override
	public void createOwner(Owner p) {
		ownerRepo.save(p);
	}

	@Override
	public void deleteOwner(Long id) {
		ownerRepo.deleteById(id);
	}

	@Override
	public void updateOwner(Long id, Owner updated) {
		Owner existing = ownerRepo.findById(id).orElse(null);

		if (existing != null) {
			existing.setName(updated.getName());
			existing.setEmail(updated.getEmail());
			existing.setPets(updated.getPets());
		}
	}

	@Override
	public List<Owner> getAllOwners() {
		return ownerRepo.findAll();
	}

	@Override
	public Owner getOwnerByName(String name) {
		return ownerRepo.findByName(name);
	}

	@Override
	public Owner getOwnerById(Long id) {
		Optional<Owner> existingOwner = ownerRepo.findById(id);
		if (existingOwner.isPresent()) {
			return existingOwner.get();
		} else {
			return null;
		}
	}
}
