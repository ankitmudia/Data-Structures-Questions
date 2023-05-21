
/**
 * Height
 */
/*
 * approach - 
 * call recursion for left and right
 * if reached root node, return 0,
 * in answer return, return Maximum of left and right + 1(which is the height of root node itself);
 */
import java.util.Scanner;

public class HeightOfTree {
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

    static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        int ans = Math.max(left, right) + 1;
        System.out.println("left: "+left+"right: "+right);
        return ans;
    }

    public static void main(String[] args) {
        // data -> 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1

        HeightOfTree I = new HeightOfTree();
        Node root = null;
        root = I.buildTree(null);
        int result = I.height(root);
        System.out.println("height: " + result);
    }
}