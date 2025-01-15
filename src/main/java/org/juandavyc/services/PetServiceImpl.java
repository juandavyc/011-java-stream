package org.juandavyc.services;

import com.github.javafaker.Faker;
import org.juandavyc.models.Cat;
import org.juandavyc.models.Dog;
import org.juandavyc.models.Pet;
import org.juandavyc.models.enums.Character;
import org.juandavyc.models.enums.Gender;
import org.juandavyc.models.enums.TypeAnimal;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class PetServiceImpl implements PetService {

    private final Locale locale = Locale.forLanguageTag("es");
    private final Faker faker = new Faker(locale);
    private final Random random = new Random();

    @Override
    public List<Pet> getPetsStream() {

        //
        Supplier<List<Object>> petSupplier = () -> {
            return Arrays.asList(
                    Float.valueOf(faker.number().digits(4)),
                    Float.valueOf(faker.number().digits(2)),
                    random.nextBoolean() ? Integer.valueOf(faker.number().digits(1)) : null,
                    random.nextBoolean() ? Gender.MALE : Gender.FEMALE,
                    String.valueOf(faker.name().firstName()),
                    faker.name().fullName(),
                    random.nextBoolean() ? "withSpecialSkill" : null,
                    random.nextBoolean() ? Character.BAD : Character.GOOD,
                    random.nextBoolean()
            );
        };

        Function<List<Object>, Pet> petFunction = (attributes) -> {

            Float weight = (Float) attributes.get(0);
            Float length = (Float) attributes.get(1);
            Integer age = (Integer) attributes.get(2);
            Gender gender = (Gender) attributes.get(3);
            String name = (String) attributes.get(4);
            String owner = (String) attributes.get(5);
            String specialSkill = (String) attributes.get(6);
            Character character = (Character) attributes.get(7);
            Boolean isCat = (Boolean) attributes.get(8);

            if (isCat) {
                return new Cat(weight, length, age, gender, name, owner, specialSkill, character);
            } else {
                return new Dog(weight, length, age, gender, name, owner, specialSkill, character);
            }
        };


        return Stream.generate(petSupplier)
                .limit(5)
                .map(petFunction)
                .toList();
    }


}
