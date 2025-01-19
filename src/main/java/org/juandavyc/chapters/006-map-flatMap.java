package org.juandavyc;

import org.juandavyc.models.Cat;
import org.juandavyc.models.Dog;
import org.juandavyc.models.Pet;
import org.juandavyc.models.enums.Character;
import org.juandavyc.models.enums.Gender;
import org.juandavyc.services.PersonServiceImpl;
import org.juandavyc.services.PetServiceImpl;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.function.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {



    public static void main(String[] args) throws URISyntaxException, IOException {

//      var personService = new PersonServiceImpl();
//      var fakeList = personService.getListStream();


        var regexLetter = "[a-zA-z]{2,}";

        var petService = new PetServiceImpl();

        // quitar lo inmutable
        List<Pet> pets = new ArrayList<>(petService.getPetsStream());
        pets.forEach(System.out::println);


        var listComplete = new ArrayList<List<Pet>>();
        var dogList = pets.stream().filter(pet-> pet instanceof Dog).toList();
        var catList = pets.stream().filter(pet-> pet instanceof Cat).toList();

        listComplete.add(dogList);
        listComplete.add(catList);


        //var resource = Main.class.getClassLoader().getResource("data");

        var pathR = Paths.get("src");

        BiPredicate<Path, BasicFileAttributes> matcher
                = (path, att)->String.valueOf(path).endsWith("txt");

        Files.find(pathR,10,matcher, FileVisitOption.FOLLOW_LINKS)
                .map(Path::toFile)
                .peek(file-> System.out.println(file.getAbsolutePath()))
                .mapToDouble(file-> (double) file.length() / 1024)
                .forEach(length-> System.out.println("size: "+length));


        System.out.println("*map flatmap");
        listComplete.forEach(System.out::println);
        // aplanado
        Stream<Pet> streamWithFlatMap = listComplete.stream().flatMap(List::stream);

        streamWithFlatMap
                .map(Pet::getGender)
                .distinct()
                .forEach(System.out::println);


//         sin aplanar
        Stream<Stream<Pet>> streamWithMap = listComplete.stream().map(List::stream);
        streamWithMap.toList().forEach(System.out::println);

//         map, flatmap,
//         flatmap combinar el mapeo y aplanamiento

        pets.stream()
                //.mapToInt(Pet::getAge)
                .map(Pet::getOwner)
                .distinct() // propietarios diferentes
                .forEach(System.out::println);


    }
}