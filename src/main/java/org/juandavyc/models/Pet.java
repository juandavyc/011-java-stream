package org.juandavyc.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.juandavyc.models.enums.Gender;
import org.juandavyc.models.enums.Habitat;
import org.juandavyc.models.enums.TypeAnimal;
import org.juandavyc.models.enums.Character;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)

public abstract class Pet extends Animal{

    @Serial
    private static final long serialVersionUID = 1L;

    protected String name, owner, specialSkill;
    protected Character character;

    public Pet( Float weight, Float length, Integer age, TypeAnimal typeAnimal, Gender gender, String name, String owner, String specialSkill, Character character) {
        super(Habitat.CITY, weight, length, age, typeAnimal, false, gender);
        this.name = name;
        this.owner = owner;
        this.specialSkill = specialSkill;
        this.character = character;
    }



}
