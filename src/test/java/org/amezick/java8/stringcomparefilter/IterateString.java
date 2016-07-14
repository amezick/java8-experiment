package org.amezick.java8.stringcomparefilter;

import org.junit.Test;

public class IterateString {
    final String str = "W00t";

    private static void printChar(int aChar) {
        System.out.println((char) aChar);
    }

    @Test
    public void displayString() {
        System.out.println("displayString");

        System.out.println("-- broken");
        str.chars().forEach(System.out::println);

        System.out.println("-- show the char not the int value");
        str.chars()
                .mapToObj(ch -> Character.valueOf((char) ch))
                .forEach(System.out::println);

        System.out.println("-- use a helper method");
        str.chars().forEach(IterateString::printChar);

        System.out.println("-- Show numbers only");
        str.chars()
                .filter(ch -> Character.isDigit(ch))
                .forEach(ch -> printChar(ch));

        System.out.println("-- use a helper method with references");
        str.chars()
                .filter(Character::isDigit)
                .forEach(IterateString::printChar);

        System.out.println("-----");

    }
}
