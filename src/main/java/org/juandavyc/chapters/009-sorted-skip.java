package org.juandavyc;

import org.juandavyc.models.ProductX;
import org.juandavyc.services.ProductServiceImpl;

import java.text.DecimalFormat;
import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {

        var productService = new ProductServiceImpl();

        // limit(n) o skip(n)

        // sorted
        // sorted() == sorted(Compatator.naturalOrder())

//        Stream.of(123, 446, 1, 6546, 54, 464, 654, 64, 8, 787, 8, 54, 231, 6546, 4)
//                .sorted(Comparator.reverseOrder())
//                .forEach(System.out::println);

        // comparador por fecha
        Comparator<ProductX> comparator = (p1,p2)-> p1.getExpirationDate().compareTo(p2.getExpirationDate());

        Stream.generate(productService::createProduct)
                .limit(10)
                //.sorted(comparator) //Comparator.reverseOrder or naturalOrder
                .sorted(Comparator.comparing(ProductX::getExpirationDate))
                //.skip(5) omite las 5 primeras
                .forEach(System.out::println);


    }
}