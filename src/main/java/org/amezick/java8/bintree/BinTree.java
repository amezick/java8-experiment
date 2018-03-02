package org.amezick.java8.bintree;

public class BinTree {
    public static void main(String[] args) {
        BinTree binTree = new BinTree();
        int[] q = { 7, 3, 5, 1 };
        binTree.start(3, q);

    }

    void BinTree() {

    }

    public int[] start(int h, int[] q) {
        Node root = new Node();
        createTree(root, h - 1);
        int value = fillTree(root, 1);

        int[] answer = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            int result = findParentValue(root, q[i]);
            answer[i] = result;
            System.out.println(q[i] + "-" + answer[i]);
        }
        return answer;
    }

    private int findParentValue(Node root, int childValue) {
        if (childValue == root.value) {
            return -1;
        }
        if (childValue == root.left.value || childValue == root.right.value) {
            return root.value;
        } else if (childValue < root.left.value) {
            return findParentValue(root.left, childValue);
        } else if (childValue < root.right.value) {
            return findParentValue(root.right, childValue);
        }
        return -2;
    }

    private int fillTree(Node node, int value) {
        if (node.left != null) {
            value = fillTree(node.left, value);
        } else {
            node.value = value;
            System.out.println(value);
            value++;
            return value;
        }
        value = fillTree(node.right, value);
        node.value = value;
        System.out.println(value);
        value++;
        return value;
    }

    private void createTree(Node node, int i) {
        node.left = new Node();
        node.right = new Node();
        if (i > 1) {
            createTree(node.left, i - 1);
            createTree(node.right, i - 1);
        }
    }

    private class Node {
        public int value;
        public Node left, right;
    }

}
