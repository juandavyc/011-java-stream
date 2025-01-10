package org.juandavyc.services;

import org.juandavyc.models.Person;

import java.util.List;

public interface PersonService {
    List<Person> getListFunctional();
    List<Person> getListStream();
}
