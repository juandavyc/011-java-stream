package org.juandavyc;

import com.google.gson.GsonBuilder;
import org.juandavyc.models.Pet;
import org.juandavyc.models.ProductX;
import org.juandavyc.models.enums.Gender;
import org.juandavyc.services.PetServiceImpl;
import org.juandavyc.services.ProductServiceImpl;


import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final float MIN_PRICE_LIMIT = 10;
    private static final float MAX_PRICE_LIMIT = 70;

    public static List<Pet> list;

    public static void main(String[] args) throws Exception {
        var petService = new PetServiceImpl();

        list = new ArrayList<>(petService.getPetsStream());

        System.out.println("Simple");
        simple();
        System.out.println("Merge");
        merge();
        System.out.println("grouping");
        grouping();

    }

    private static void simple() {
        // Clave-pet Valor -> su Json

        var gsonObj = new GsonBuilder().setPrettyPrinting()
                .create();

        // El indice es el objeto y el valor un json del objeto
        Map<Pet, String> map = list.stream()
                .limit(4)

                .collect(
                        Collectors.toMap(
                                Function.identity(), // devueve el mismo, return pet->pet
                               gsonObj::toJson // aca ta va pet
                        )
                );
//                .collect(
//                        Collectors.toMap(
//                                pet -> pet,
//                                pet -> gsonObj.toJson(pet)
//                        )
//                );

        System.out.println(map.get(list.getFirst())); // get(n)
    }

    private static void merge() {

        // clave->genero

        Function<Pet, List<Pet>> valueMap = pet->{
            var lst = new ArrayList<Pet>();
            lst.add(pet);
            return lst;
        };

        BinaryOperator<List<Pet>> merge = (lst,lst2)->{
            lst2.addAll(lst);
            return lst2;
        };

        Map<Gender,List<Pet>> mapf = list.stream()
                .collect(
                        Collectors.toMap(
                                Pet::getGender,
                                valueMap,
                                merge
                        )
                );

        mapf.entrySet().forEach(System.out::println);
    }

    private static void grouping() {

        // merge es mas eficiciente con groupby
        // female, (a,b,c,d)
        // foreach(key, value-> value.foreach...)

        Map<Gender, List<Pet>> map = list.stream()
                .collect(
                        Collectors.groupingBy(
                                Pet::getGender
                        )

                );

//        map
//                .entrySet()
//                .forEach(System.out::println);

        map.entrySet().forEach(entry->{
            System.out.println("Gender: "+entry.getKey());
            entry.getValue().forEach(System.out::println);
        });
    }

}