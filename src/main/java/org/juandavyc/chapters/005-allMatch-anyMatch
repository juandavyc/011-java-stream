package org.juandavyc;

import org.juandavyc.models.Cat;
import org.juandavyc.models.Dog;
import org.juandavyc.models.Pet;
import org.juandavyc.models.enums.Character;
import org.juandavyc.models.enums.Gender;
import org.juandavyc.services.PersonServiceImpl;
import org.juandavyc.services.PetServiceImpl;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.function.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

//      var personService = new PersonServiceImpl();
//      var fakeList = personService.getListStream();


        var regexLetter = "[a-zA-z]{2,}";

        var petService = new PetServiceImpl();
        // quitar lo inmutable

        List<Pet> pets = new ArrayList<>(petService.getPetsStream());
        pets.forEach(System.out::println);

        System.out.println("allMatch");
        var pattern = Pattern.compile(regexLetter);

        Predicate<Pet> petNameContains = pet -> pattern.matcher(pet.getName()).find();
        Predicate<Pet> petOverXYearsOld = pet ->
                Optional.ofNullable(pet.getAge())
                        .map(age -> age > 3)
                        .orElse(false);

        // allMatch // todos coincidan
        // anyMatch // alguno coincida
        // noneMatch // Ninguno coincide con el predicado

        var coincidences = pets.stream()
                .peek(pet -> {
                    System.out.println(pet.getName() + " - " + pet.getAge() + " - " + pet.getWeight());
                })
                .anyMatch(
                        pet -> petNameContains
                                .and(petOverXYearsOld)
                                .test(pet)
                );

        var message = coincidences ? "Se ha encontrado" : "No se ha encontrado";
        System.out.println(message);

        System.out.println("** isFirulaisAndOwner ?? **");

        var dogList = pets.stream().filter(pet -> pet instanceof Dog).toList();
        var catList = pets.stream().filter(pet -> pet instanceof Cat).toList();

        var complexList = new ArrayList<List<Pet>>();

        complexList.add(dogList);
        complexList.add(catList);


        complexList.stream().filter(
                list -> list.stream()
                        .allMatch(Main::isFirulaisAndOwner)
        ).forEach(list -> {
            System.out.println("-----");
            list.forEach(System.out::println);
        });

    }

    private static boolean isFirulaisAndOwner(Pet pet) {
        Predicate<Pet> isOwner = e -> e.getOwner()
                .equals("raquel");
        Predicate<Pet> isFirulais = e -> e instanceof Dog;

        return isOwner.and(isFirulais).test(pet);
    }

}