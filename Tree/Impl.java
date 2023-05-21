
/**
 * Impl
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Impl {
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

        System.out.println("Enter Data for left: "+root.data);
        root.left = buildTree(root.left);
        System.out.println("Enter Data for right: "+root.data);
        root.right = buildTree(root.right);

        return root;
    }

    void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            Node temp = q.poll();

            System.out.print(temp.data+ " ");

            if(temp.left != null) {
                q.add(temp.left);
            }
            if(temp.right != null) {
                q.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        //data -> 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
        
        Impl I = new Impl();
        Node root = null;
        root = I.buildTree(null);

        I.levelOrder(root);
    }
}