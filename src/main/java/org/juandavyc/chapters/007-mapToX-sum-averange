package org.juandavyc;

import org.juandavyc.models.Cat;
import org.juandavyc.models.Dog;
import org.juandavyc.models.Pet;
import org.juandavyc.models.ProductX;
import org.juandavyc.models.enums.Character;
import org.juandavyc.models.enums.Gender;
import org.juandavyc.services.PersonServiceImpl;
import org.juandavyc.services.PetServiceImpl;
import org.juandavyc.services.ProductService;
import org.juandavyc.services.ProductServiceImpl;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.function.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        var productService = new ProductServiceImpl();

        List<ProductX> products = Stream.generate(productService::createProduct)
                .limit(10)
                .toList();

        products.forEach(System.out::println);

        var quantityOfProductsInStock = products.stream().count();

        var quatintyOfDifferentProductsInStock = products.stream()
                .map(ProductX::getName)
                .distinct()
                .count();

        var quantityOfDifferentMaterialProducts = products.stream()
                .map(ProductX::getMaterial)
                .distinct()
                .count();


        System.out.println("----------");
        System.out.println("quantityOfProductsInStock: " + quantityOfProductsInStock);
        System.out.println("quatintyOfDifferentProductsInStock: " + quatintyOfDifferentProductsInStock);
        System.out.println("quantityOfDifferentMaterialProducts: " + quantityOfDifferentMaterialProducts);

        // tipos primitivos

        var format = new DecimalFormat("#.##");

        var averange = products.stream()
                .mapToDouble(ProductX::getPrice)
                .average()
                .orElse(0.0);

        var sum = products.stream()
                .mapToDouble(ProductX::getPrice)
                .sum();


        var averangeExpiration = products.stream()
                .mapToInt(pro -> {
                    return LocalDate.from(pro.getExpirationDate()).getYear() - LocalDate.now().getYear();
                })
                .average()
                .orElse(0.0f);

        System.out.println("averange: " + format.format(averange));
        System.out.println("sum: " + format.format(sum));
        System.out.println("averangeExpiration: " + averangeExpiration);


    }
}