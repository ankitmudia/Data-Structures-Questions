/*
 * approach - 
    add root node in list first,
    then left nodes, then leaf nodes and then right nodes,
    int such a order that it becomes boundary traversal
 */

import java.util.ArrayList;
import java.util.Scanner;

public class BoundaryTraversal {
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

    void left(Node root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }

        result.add(root.data);

        // left subtree;
        left(root.left, result);
        if (root.left == null) {
            left(root.right, result);
        }
    }

    void right(Node root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }

        right(root.right, result);
        if (root.right == null) {
            right(root.left, result);
        }
        result.add(root.data);
    }

    void leaf(Node root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(root.data);
            return;
        }

        leaf(root.left, result);
        leaf(root.right, result);
    }

    public static void main(String[] args) {
        // data -> 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1

        BoundaryTraversal I = new BoundaryTraversal();
        Node root = null;
        root = I.buildTree(null);
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            System.out.println(result);
            ;
        }
        if (root.left == null && root.right == null) {
            result.add(root.data);
            System.out.println(result);
        }

        result.add(root.data);

        // left
        I.left(root.left, result);

        // leaf
        I.leaf(root, result);

        // right
        I.right(root.right, result);

        System.out.println("Boundary traversal: " + result);
    }
}
