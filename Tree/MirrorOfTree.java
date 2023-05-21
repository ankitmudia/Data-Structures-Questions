
/**
 * MirrorOfTree
 */
/*
 * approach -
 * traverse the left and right of tree using recursion
 * if reached end, return from there,
 * and while returning swap the child nodes of a node, using a temp variable of Node type
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MirrorOfTree {
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

    void mirror(Node root) {
        if (root == null) {
            return;
        }

        mirror(root.left);
        mirror(root.right);

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    void levelTraverse(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        // data -> 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1

        MirrorOfTree I = new MirrorOfTree();
        Node root = null;
        root = I.buildTree(null);

        I.levelTraverse(root);
        I.mirror(root);
        I.levelTraverse(root);
    }
}