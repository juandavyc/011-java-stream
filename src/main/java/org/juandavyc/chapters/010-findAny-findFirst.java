package org.juandavyc;

import org.juandavyc.models.ProductX;
import org.juandavyc.services.ProductServiceImpl;

import java.text.DecimalFormat;
import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class Main {
    private static final float MIN_PRICE_LIMIT = 10;
    private static final float MAX_PRICE_LIMIT = 70;


    public static void main(String[] args) throws Exception {

        var productService = new ProductServiceImpl();

        // generar
        List<ProductX> products = Stream.generate(productService::createProduct)
                .limit(100)
                // .peek(System.out::println)
                .toList();

        // Producto valido
        // Precio entre x e y
        // si el material es Steel u Plastic

        Predicate<ProductX> priceOverX = prod -> prod.getPrice() > MIN_PRICE_LIMIT;
        Predicate<ProductX> priceLessThanY = prod -> prod.getPrice() < MAX_PRICE_LIMIT;
        Predicate<ProductX> isPlastic = prod -> prod.getMaterial().equals("Plastic");
        Predicate<ProductX> isIron = prod -> prod.getMaterial().equals("Iron");

        Predicate<ProductX> isValid =
                priceOverX.and(isIron.or(isPlastic)).and(priceLessThanY);


        var productsValidCount = products.stream().filter(isValid)
                .count();

        System.out.println("Tememos: " + productsValidCount + " validos");


        Supplier<ProductX> productS = () -> products.stream()
                .filter(isValid)
                .findFirst()
                .orElse(null);


        Supplier<ProductX> productP = () -> products.stream()
                .filter(isValid)
                .findAny()
                .orElse(null);


        getSet(productS).forEach(System.out::println);
        System.out.println("--- product p ----");
        getSet(productP).forEach(System.out::println);


        Optional<Integer> firstEvenNumber = Stream.of(1, 3, 5, 6, 7)
                .peek(System.out::println)
                .filter(num -> num % 2 == 0)
                .findFirst();

        System.out.println("findFirst");
        firstEvenNumber.ifPresent(System.out::println);
        System.out.println();


    }


    private static Set<ProductX> getSet(Supplier<ProductX> product) {

        var setOfProd = new HashSet<ProductX>();
        for (int i = 0; i < 100; i++) {
            setOfProd.add(product.get());
        }

        return setOfProd;
    }

}