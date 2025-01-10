package org.juandavyc;

import org.juandavyc.services.PersonServiceImpl;
import org.juandavyc.services.PetServiceImpl;

public class Main {

    public static void main(String[] args) {

//        var personService = new PersonServiceImpl();
//        var fakeList = personService.getListStream();

        var petService = new PetServiceImpl();
        var fakeList = petService.getPetsStream();


        fakeList.forEach(System.out::println);

    }

}