package org.juandavyc;

import org.juandavyc.models.Dog;
import org.juandavyc.models.Pet;
import org.juandavyc.models.enums.Character;
import org.juandavyc.services.PersonServiceImpl;
import org.juandavyc.services.PetServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//      var personService = new PersonServiceImpl();
//      var fakeList = personService.getListStream();

        var petService = new PetServiceImpl();
        // quitar lo inmutable

        List<Pet> list = new ArrayList<>(petService.getPetsStream());

        System.out.println("Original");
        list.forEach(System.out::println);

        System.out.println("Filtrada");

        var count = list.stream()
                .filter(pet->pet instanceof Dog)
                .peek(System.out::println)
                .filter(pet->pet.getCharacter() == Character.GOOD)
                .count();

        System.out.println("Perros de mal comportamiento: "+count);



    }

}