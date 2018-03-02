package org.amezick.java8.arr;

import java.util.Arrays;

public class Arr {
    public static void main(String[] args) {
        int x[] = { 13, 5, 6, 2, 5 };
        int y[] = { 5, 2, 5, 13 };

        Arrays.sort(x);
        Arrays.sort(y);
        int searcher[];
        int searchee[];
        if (x.length > y.length) {
            searcher = x;
            searchee = y;
        } else {
            searcher = y;
            searchee = x;
        }

        for (int i : searcher) {
            boolean found = false;
            for (int j : searchee) {
                if (i == j) {
                    found = true;
                    break;
                }
            }
            if (found == false) {
                System.out.println(i);
                break;
            }
        }

        byte bArray[] = { 1, 2, 3, 4, 5 };
        Arrays.sort(bArray);

        byte searchValue = 2;

        int intResult = Arrays.binarySearch(bArray, searchValue);
        System.out.println("Result of binary search of 2 is : " + intResult);

        searchValue = 7;
        intResult = Arrays.binarySearch(bArray, searchValue);
        System.out.println("Result of binary search of 3 is : " + intResult);
    }
}
