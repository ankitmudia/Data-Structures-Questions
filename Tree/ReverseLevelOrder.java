
/**
 * ReverseLevelOrder
 */
/*
 * approach - 
 * Enter root node in Queue
 * while Queue is not empty,poll node from Queue and put in array list,
 * if right and left child of that node exists, put right first and then left in Queue.
 * exit while loop and print arraylist in reverse order to get the reverse level order traversal. 
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class ReverseLevelOrder {
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

    void reverseLevelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            result.add(temp.data);
            if (temp.right != null) {
                q.add(temp.right);
            }
            if (temp.left != null) {
                q.add(temp.left);
            }
        }
        Collections.reverse(result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        // data -> 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1

        ReverseLevelOrder I = new ReverseLevelOrder();
        Node root = null;
        root = I.buildTree(null);

        I.reverseLevelOrder(root);
    }
}