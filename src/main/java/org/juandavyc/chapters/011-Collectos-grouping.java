package org.juandavyc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.juandavyc.models.Pet;
import org.juandavyc.models.enums.Character;
import org.juandavyc.services.PetServiceImpl;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    private static final float MIN_PRICE_LIMIT = 10;
    private static final float MAX_PRICE_LIMIT = 70;

    public static List<Pet> list;
    private static Gson gsonConverter;

    public static void main(String[] args) throws Exception {
        var petService = new PetServiceImpl();

        gsonConverter = new GsonBuilder().setPrettyPrinting().create();

        list = new ArrayList<>(petService.getPetsStream());

//        list.stream()
//                .map(gsonConverter::toJson)
//                .forEach(System.out::println);


        groupingBySimple().entrySet().forEach(System.out::println);

        groupingMedium().entrySet().forEach(System.out::println);

        groupingComplete().entrySet().forEach(System.out::println);

        groupingComplex().entrySet().forEach(System.out::println);
    }

    private static Map<Integer, String> groupingComplex() {


        Function<Pet, Integer> classifier =
                pet-> Optional.ofNullable(pet.getAge()).orElse(0) > 5 ? 1 : 0;


        Collector<Pet, ?, String> downStream =
                Collectors.mapping(Pet::getName, Collectors.joining(", "));

        return list.stream().collect(Collectors.groupingBy(classifier, downStream));
    }


    private static LinkedHashMap<String, Set<Pet>> groupingComplete() {

        return list.stream().collect(
                Collectors.groupingBy(Pet::getOwner, LinkedHashMap::new, Collectors.toSet())
        );
    }


    private static Map<Class<? extends Pet>, Long> groupingMedium() {
        return list.stream().collect(
                Collectors.groupingBy(
                        Pet::getClass,
                        Collectors.counting()
                )
        );
    }

    private static Map<Character, List<Pet>> groupingBySimple() {
        return list.stream().collect(
                Collectors.groupingBy(Pet::getCharacter)
        );
    }

}