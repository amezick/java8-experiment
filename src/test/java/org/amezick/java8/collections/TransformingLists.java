package org.amezick.java8.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Test;

public class TransformingLists {
    final List<String> people =
            Arrays.asList("Cari", "Tayah", "David", "Mike", "Levi", "Richard", "Jennie", "Kelly", "Priscilla", "Kim");

    final List<String> pets =
            Arrays.asList("Amigo", "Violet", "Tandem", "Tigger", "Katie", "Syndey");

    @Test
    public void upperCase() {
        System.out.println("UpperCase1");
        people.stream()
                .map(name -> name.toUpperCase())
                .forEach(name -> System.out.print(name + " "));
        System.out.println("");
        people.stream()
                .map(name -> name.length())
                .forEach(count -> System.out.print(count + " "));
        System.out.println("\n-----");
    }

    @Test
    public void upperCaseMethodReference() {
        System.out.println("UpperCaseMethodReference");
        people.stream()
                .map(String::toUpperCase)
                .forEach(name -> System.out.print(name + " "));
        System.out.println("");
        people.stream()
                .map(String::length)
                .forEach(count -> System.out.print(count + " "));
        System.out.println("\n-----");
    }

    @Test
    public void startsWithK() {
        System.out.println("StartsWithK");
        final List<String> startsWithK =
                people.stream()
                        .filter(name -> name.startsWith("K"))
                        .collect(Collectors.toList());
        System.out.println(String.format("Found %d names", startsWithK.size()));
        System.out.println("-----");
    }

    @Test
    public void reusingLambda() {
        System.out.println("reusingLambda");
        final Predicate<String> startsWithK = name -> name.startsWith("K");
        System.out.println("people: " + people.stream().filter(startsWithK).count());
        System.out.println("pets: " + pets.stream().filter(startsWithK).count());
        System.out.println("-----");
    }

    final Function<String, Predicate<String>> startsWithLetter1 =
            (String letter) -> {
                Predicate<String> checkStartsWith =
                        (String name) -> name.startsWith(letter);
                return checkStartsWith;
            };
    final Function<String, Predicate<String>> startsWithLetter2 =
            letter -> name -> name.startsWith(letter);

    @Test
    public void lambdaReuseWithArgument() {
        System.out.println("lambdaReuseWithArgument");
        long swl1k = people.stream().filter(startsWithLetter1.apply("K")).count();
        long swl2k = people.stream().filter(startsWithLetter2.apply("K")).count();
        System.out.println(swl1k + "|" + swl2k);
        System.out.println("-----");
    }

    @Test
    public void pickFirstName() {
        System.out.println("pickFirstName");

        final Optional<String> foundName =
                people.stream()
                        .filter(name -> name.startsWith("K"))
                        .findFirst();
        System.out.println(String.format("A name starting with K: %s", foundName.orElse("No name found")));
        foundName.ifPresent(name -> System.out.println("Hello " + name));
        final Optional<String> foundName2 =
                people.stream()
                        .filter(name -> name.startsWith("Z"))
                        .findFirst();
        System.out.println(String.format("A name starting with Z: %s", foundName2.orElse("No name found")));
        foundName2.ifPresent(name -> System.out.println("Hello " + name));
        System.out.println("-----");
    }

    @Test
    public void lambdaReduceOperations() {
        System.out.println("lambdaReduceOperations");
        //sum all the name lengths into one int
        System.out.println("Total length of all names: " +
                people.stream()
                        .mapToInt(name -> name.length())
                        .sum()
                );
        //find the longest name
        final Optional<String> longestName =
                people.stream()
                        .reduce((name1, name2) -> name1.length() >= name2.length() ? name1 : name2);
        longestName.ifPresent(name -> System.out.println(String.format("Longest Name: %s", name)));

        //Add a default first term to the reduce operation
        final String steveOrLonger =
                people.stream()
                        .reduce("Steve", (name1, name2) -> name1.length() >= name2.length() ? name1 : name2);
        System.out.println(String.format("Longest Name or steve: %s", steveOrLonger));
        final String steveOrShorter =
                people.stream()
                        .reduce("Steve", (name1, name2) -> name1.length() <= name2.length() ? name1 : name2);
        System.out.println(String.format("Shortest Name or steve: %s", steveOrShorter));
        System.out.println("-----");

    }

    @Test
    public void joiningElements() {
        System.out.println("joiningElements");
        System.out.println(people.stream().map(String::toUpperCase).collect(Collectors.joining(", ")));
        System.out.println("-----");

    }
}
