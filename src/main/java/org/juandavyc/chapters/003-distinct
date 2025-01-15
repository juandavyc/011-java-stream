package org.juandavyc;

import org.juandavyc.models.Pet;
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
        System.out.println("**lista original **");
        list.forEach(System.out::println);
        System.out.println("**lista duplicada **");
        // la duplico para el ejemplo
        list.addAll(list);
        list.forEach(System.out::println);

        System.out.println("**lista distinta**");

        var listNew = new ArrayList<Pet>();
        list.stream()
                .distinct() // evalua por EqualsHashCode
                .forEach(listNew::add);
        listNew.forEach(System.out::println);

    }

}