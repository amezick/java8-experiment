package org.amezick.java8.bintree;

public class BinTree2 {

    public static void main(String[] args) {
        //int[] q = { 7, 3, 5, 1 };
        int[] q = { 19, 14, 28 };
        int h = 7;

        int root = (int) Math.pow(2, h) - 1;

        for (int target : q) {
            System.out.println(getParent(target, root));
        }

    }

    public static int getParent(int target, int h) {
        int rank = h;
        int index = h;

        while (rank > 0) {
            int leftIndex = index - (rank + 1) / 2;
            int rightIndex = index - 1;

            if (target == leftIndex || target == rightIndex) {
                return index;
            }

            index = (target < leftIndex ? leftIndex : rightIndex);
            rank = (rank - 1) / 2;
        }
        return -1;
    }

}
