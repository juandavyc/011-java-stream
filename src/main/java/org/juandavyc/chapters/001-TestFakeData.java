package org.juandavyc.chapters;

import org.juandavyc.services.PersonServiceImpl;

public class Fake {

    public static void main(String[] args) {

        var personService = new PersonServiceImpl();
        var fakeList = personService.getListStream();

        fakeList.forEach(System.out::println);

    }

}