package org.amezick.java8.lambs;

public class Lambs {

    public static void main(String[] args) {
        int target = 10;

        //int fibCount = countFibs(target);
        //System.out.println(countFibs(10));
        //System.out.println(countFibs(11));
        //System.out.println(countFibs(12));
        // System.out.println(countFibs(13));
        //System.out.println(countFibs(1000000000));
        //System.out.println(countSquare(10));
        System.out.println(countSquare(12));
        System.out.println(countSquare(13));
        System.out.println(countSquare(14));
        //System.out.println(countSquare(15));
        //System.out.println(countSquare(16));
        //System.out.println(countSquare(1000000000));
        //System.out.println("Answer: " + answer(10));
        //System.out.println("Answer: " + answer(12));
        //System.out.println("Answer: " + answer(15));
        //System.out.println("Answer: " + answer(1000000000));
    }

    private static int answer(int i) {

        return countFibs(i) - countSquare(i);
    }

    private static int countSquare(int target) {
        int prev = 1;
        int checksum = 1;
        int current = 1;
        int leftOver;
        int total = 1;
        int count = 1;
        do {
            checksum = prev + current;
            prev = current;
            leftOver = target - total;
            current *= 2;
            total += current;
            count++;
            //System.out.println(count + "|" + current + "|" + total + "|" + prev + "|" + checksum);
        } while (total <= target);
        //System.out.println(leftOver);
        if (leftOver >= checksum) {
            return count;
        }
        //System.out.println("Square:" + (count - 1));
        return count - 1;
    }

    private static int countFibs(int target) {
        int a = 1, b = 1, sum, total = 2;
        int count = 2;
        do {
            sum = a + b;
            a = b;
            b = sum;
            total += sum;
            count++;
            //System.out.println(count + "|" + sum + "|" + total);
        } while (total <= target);
        //System.out.println("Fibs:" + (count - 1));
        return count - 1;
    }

}
