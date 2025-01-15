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
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

//      var personService = new PersonServiceImpl();
//      var fakeList = personService.getListStream();

        var petService = new PetServiceImpl();
        // quitar lo inmutable

        List<Pet> pets = new ArrayList<>(petService.getPetsStream());
        System.out.println("Original");

        pets.forEach(System.out::println);
    }

}