package org.juandavyc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.juandavyc.models.Pet;
import org.juandavyc.models.PetDto;
import org.juandavyc.models.enums.Character;
import org.juandavyc.models.enums.Gender;
import org.juandavyc.services.PetServiceImpl;


import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
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

        var isMale = true;
        Predicate<Pet> partition = pet -> pet.getGender() == Gender.MALE;


        Predicate<PetDto> filter= pet->pet.character == Character.GOOD;

        Function <Pet, PetDto> mapper = PetDto::new;

        Collector<PetDto, ? , List<PetDto>> filtering =
                Collectors.filtering(filter, Collectors.toUnmodifiableList());

        Collector<Pet, ?, List<PetDto>> mapping = Collectors.mapping(mapper,filtering);


        Collector<Pet, ? , Map<Boolean, List<PetDto>>> partitioningByy
                = Collectors.partitioningBy(partition, mapping);


        var newMap = list.stream()
                .collect(partitioningByy);

        newMap.get(isMale).stream()
                .map(gsonConverter::toJson)
                .forEach(System.out::println);

    }

}