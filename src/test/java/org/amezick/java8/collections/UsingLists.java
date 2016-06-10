/**
 *
 */
package org.amezick.java8.collections;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

/**
 * Simple scratch test to play with Java8 List processing. I am using the Test annotation as a simple code runner
 * so that I don't need to deal with a main method. Working this way also allows me to only run the methods
 * that are important at the moment instead of having to run all the code I write.
 *
 */
public class UsingLists {
    final List<String> people =
            Arrays.asList("Cari", "Tayah", "David", "Mike", "Levi", "Richard", "Jennie", "Kelly", "Priscilla");

    /**
     * The full signature of using a Consumer without any syntax sugar.
     */
    @Test
    public void forEachLongForm() {
        System.out.println("forEachLongForm");
        people.forEach(new Consumer<String>() {
            @Override
            public void accept(final String name) {
                System.out.println(name);
            }
        });
        System.out.println("--------");
    }

    /**
     * Switch to using a lambda to remove all the boiler plate
     */
    @Test
    public void forEachLambda1() {
        System.out.println("forEachLambda1");
        people.forEach((final String name) -> System.out.println(name));
        System.out.println("--------");
    }

    /**
     *
     */
    @Test
    public void forEachLambda2() {
        System.out.println("forEachLambda2");
        people.forEach((name) -> System.out.println(name));
        System.out.println("--------");
    }

    @Test
    public void forEachLambda3() {
        System.out.println("forEachLambda3");
        people.forEach(name -> System.out.println(name));
        System.out.println("--------");
    }

    /**
     * Last simplification using a method reference to really compress the call
     */
    @Test
    public void forEachLambda4() {
        System.out.println("forEachLambda4");
        people.forEach(System.out::println);
        System.out.println("--------");
    }
}
