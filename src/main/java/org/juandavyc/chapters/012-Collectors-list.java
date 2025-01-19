package org.juandavyc;

import org.juandavyc.models.ProductX;
import org.juandavyc.services.ProductServiceImpl;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final float MIN_PRICE_LIMIT = 10;
    private static final float MAX_PRICE_LIMIT = 70;

    public static List<ProductX> products;
    public static void main(String[] args) throws Exception {
        var productService = new ProductServiceImpl();

        var generateProducts = Stream.generate(productService::createProduct)
                .limit(10);

        products = new ArrayList<ProductX>(generateProducts.toList());

        //products.forEach(System.out::println);
        System.out.println("PriceLessThan20");

        Collector<String, ?, List<String>> collector = Collectors.toList();
        Collector<String, ?, List<String>> collector2 = Collectors.toCollection(LinkedList::new);
        Collector<String, ?, List<String>> collector3 = Collectors.toUnmodifiableList(); // inmutable
        Collector<String, ?, Set<String>> collector4 = Collectors.toSet(); // no repite
        Collector<String, ?, Set<String>> collector5 = Collectors.toCollection(TreeSet::new); // natural order

        printTypeOfCollection(collector).forEach(System.out::println);
        printTypeOfCollection(collector2).forEach(System.out::println);
        printTypeOfCollection(collector3).forEach(System.out::println);
        printTypeOfCollection(collector4).forEach(System.out::println);
        printTypeOfCollection(collector5).forEach(System.out::println);

    }

    private static <T> T printTypeOfCollection(Collector<String,?,T> collector){

        var collection = products.stream()
                //.filter(pro->pro.getPrice() <20)
                .map(ProductX::getMaterial)
                .collect(collector);

        System.out.println("Material:: <<"+collection.getClass().getSimpleName()+">>");

        return collection;
    }


}