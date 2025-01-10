package org.juandavyc.models;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.juandavyc.models.enums.Gender;
import org.juandavyc.models.enums.TypeAnimal;
import org.juandavyc.models.enums.Character;

import java.io.Serial;
import java.util.Set;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Cat extends Pet{

    @Serial
    private static final long serialVersionUID = 1L;
    private static Set<String> setOfSkills = Set.of("Arañar","Moverse silenciosamente","Dormir","Saltar","Trepar",
            "Perseguir cualquier cosa inanimada");
    public Cat(Float weight, Float length, Integer age, Gender gender, String name, String owner, String specialSkill, Character character) {
        super(weight, length, age, TypeAnimal.CAT, gender, name, owner, specialSkill, character);
    }
}
