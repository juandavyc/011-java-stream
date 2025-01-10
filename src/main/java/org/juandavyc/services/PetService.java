package org.juandavyc.services;

import org.juandavyc.models.Pet;

import java.util.List;

public interface PetService {
    List<Pet> getPetsStream();
}
