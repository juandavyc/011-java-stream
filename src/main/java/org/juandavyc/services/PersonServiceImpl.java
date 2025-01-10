package org.juandavyc.services;

import com.github.javafaker.Faker;
import org.juandavyc.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class PersonServiceImpl implements PersonService {

    private final Locale locale = Locale.forLanguageTag("es");
    private final Faker faker = new Faker(locale);
    private final Random random = new Random();

    @Override
    public List<Person> getListFunctional() {
        List<Person> people = new ArrayList<>();
        return people;
    }

    public List<Person> getListStream() {
        Supplier<Person> peopleSupplier = () -> {
            var person = new Person();

            var firsName = faker.name().firstName();
            var lastName = faker.name().lastName();

            person.setFirstName(firsName);
            person.setLastName(lastName);
            person.setDocument(Integer.valueOf(faker.number().digits(9)));

            // opcionals fields
            person.setAge(random.nextBoolean() ? random.nextInt(60) + 18 : null);
            person.setSex(random.nextBoolean() ? faker.demographic().sex() : null);
            person.setAddress(random.nextBoolean() ? faker.address().streetAddress() : null);
            person.setFloor(random.nextBoolean() ? faker.address().buildingNumber() : null);
            person.setEmail(random.nextBoolean() ? (firsName.concat("_").concat(lastName).concat("@").concat(faker.internet().domainName())) : null);
            person.setNationality(random.nextBoolean() ? faker.address().country() : null);

            return person;
        };
        return Stream.generate(peopleSupplier).limit(20).toList();
    }

}
