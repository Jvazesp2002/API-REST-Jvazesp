package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.persistence.Owner;

@Service
public interface OwnerServiceI {

	public void createOwner(Owner p);
	public void deleteOwner(Long id);
	public void updateOwner(Long id, Owner updated);
	public List<Owner> getAllOwners();
	public Owner getOwnerByName(String name);
	public Owner getOwnerById(Long id);
}
