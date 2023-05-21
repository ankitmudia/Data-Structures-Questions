/*
 * approach - 
 * we will use level order traversal,
 * only change we will have is that, we will store the
 * value from leftToright and rightToLeft based on a boolean variable
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ZigZagTraversal {
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

    void zigZag(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            int[] tempArr = new int[size];

            for (int i = 0; i < size; i++) {
                Node temp = q.poll();
                int index = leftToRight ? i : size - i - 1;
                tempArr[index] = temp.data;

                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            // change the direction
            leftToRight = !leftToRight;

            for (int i = 0; i < tempArr.length; i++) {
                result.add(tempArr[i]);
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        // data -> 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1

        ZigZagTraversal I = new ZigZagTraversal();
        Node root = null;
        root = I.buildTree(null);

        I.zigZag(root);
    }
}
