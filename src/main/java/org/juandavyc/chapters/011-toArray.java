package org.juandavyc;

import org.juandavyc.models.Pet;
import org.juandavyc.models.ProductX;
import org.juandavyc.services.PetServiceImpl;
import org.juandavyc.services.ProductServiceImpl;

import java.text.DecimalFormat;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final float MIN_PRICE_LIMIT = 10;
    private static final float MAX_PRICE_LIMIT = 70;


    public static void main(String[] args) throws Exception {

        var petService = new PetServiceImpl();


        List<Pet> pets = petService.getPetsStream();
        pets.forEach(System.out::println);

        // recolecciones :
        // Collectors
        // Collector

        // generar string[xxx] dinamicos
        IntFunction<String[]> generator = String[]::new;

        String[] arr = pets.stream()
                .map(Pet::getOwner)
                .distinct()
                .toArray(generator);

        System.out.println(Arrays.toString(arr));


        String[] names = Stream.of("Juana","Maria","Valentina")
                .toArray(generator);

        for (String name:names){
            System.out.println(name);
        }


    }


}