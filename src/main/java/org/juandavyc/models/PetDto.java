package org.juandavyc.models;

import org.juandavyc.models.enums.Character;

public class PetDto {

    public String name,owner;
    public int age;
    public Character character;
    public PetDto(Pet pet){
        name = pet.getName();
        owner = pet.getOwner();
        age = pet.getAge();
        character = pet.getCharacter();
    }


}
