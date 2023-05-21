/*
 * Approach-
 * traverse the whole tree through recursion, left first and then right
 * before calling recusrion for left child,
 * make sure to check if the level matches arraylist's size, if does
 * add root's data in it.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class LeftView {
    public class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node buildTree(Node root) {
        System.out.println("Enter data: ");
        Scanner sc = new Scanner(System.in);

        int value = sc.nextInt();
        root = new Node(value);

        if (value == -1) {
            return null;
        }

        System.out.println("Enter Data for left: ");
        root.left = buildTree(root.left);
        System.out.println("Enter Data for right: ");
        root.right = buildTree(root.right);

        return root;
    }

    void leftView(Node root, ArrayList<Integer> result, int level) {
        if (root == null) {
            return;
        }

        if (level == result.size()) {
            result.add(root.data);
        }

        leftView(root.left, result, level + 1);
        leftView(root.right, result, level + 1);
    }

    public static void main(String[] args) {
        // data -> 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
        ArrayList<Integer> result = new ArrayList<>();
        LeftView I = new LeftView();
        Node root = null;
        root = I.buildTree(null);
        I.leftView(root, result, 0);
        System.out.println(result);
    }
}
