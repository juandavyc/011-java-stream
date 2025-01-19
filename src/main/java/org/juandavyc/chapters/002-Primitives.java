package org.juandavyc;

import java.util.function.IntConsumer;
import java.util.function.IntUnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        IntUnaryOperator operatorInfinite = intValue -> intValue + 1;
        IntUnaryOperator operatorFinite = intValue -> intValue <= 1000 ? intValue + 1 : null;

        IntConsumer intAction = System.out::println;
        IntStream.iterate(0, operatorInfinite)
                .takeWhile(value -> value <= 1000)
                .forEach(intAction);

        IntStream.range(0,1000).forEach(System.out::println);
        IntStream.rangeClosed(0,1000).forEach(System.out::println);

    }

}