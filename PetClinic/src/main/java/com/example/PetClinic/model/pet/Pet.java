package com.example.PetClinic.model.pet;

import java.time.LocalDate;

import com.example.PetClinic.model.person.Owner;

public class Pet {
	private PetType petType;
	private Owner owner;
	private LocalDate birthDate;

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
}
