package org.juandavyc.models;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.juandavyc.models.enums.Gender;
import org.juandavyc.models.enums.Character;
import org.juandavyc.models.enums.TypeAnimal;

import java.io.Serial;
import java.util.Set;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Dog extends Pet{

    @Serial
    private static final long serialVersionUID = 1L;
    private final static Set<String> setOfSkills = Set.of("Olfatear","Empatía","Proteger","Jugar","Correr");

    public Dog(Float weight, Float length, Integer age, Gender gender, String name, String owner, String specialSkill, Character character) {
        super(weight, length, age,TypeAnimal.DOG, gender, name, owner, specialSkill, character);
    }


}
