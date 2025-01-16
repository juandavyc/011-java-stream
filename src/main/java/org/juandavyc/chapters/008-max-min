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
        var format = new DecimalFormat("#.##");

        List<ProductX> products = Stream.generate(productService::createProduct)
                .limit(10)
                .toList();

        products.forEach(System.out::println);

        Comparator<ProductX> comparator = (p1,p2)->{
            // price
             return Float.compare(p1.getPrice(), p2.getPrice());
            // names
            //return p1.getName().compareToIgnoreCase(p2.getName());
        };

        Predicate<ProductX> isPaper = p->p.getMaterial().equals("Paper"); // OtherName
        Supplier<Exception> error = ()-> new Exception("No encontrado");

        // min max

        var max = products.stream()
                .filter(isPaper)
                .mapToDouble(ProductX::getPrice)
                .max()
                .orElse(Double.MIN_VALUE);
                //.max(comparator) // comparator.reversed()

                //.orElseThrow(error);

        var min = products.stream()
                .min(comparator)
                .orElse(null);

        System.out.println();
        System.out.println("Max: "+format.format(max));
        System.out.println("Min: "+min);

    }
}