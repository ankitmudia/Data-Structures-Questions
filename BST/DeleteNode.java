import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class DeleteNode {
    static Node insertInBST(int data, Node root) {
        if (root == null) {
            Node n = new Node(data);
            root = n;
            return root;
        }

        if (data > root.data) {
            root.right = insertInBST(data, root.right);
        } else {
            root.left = insertInBST(data, root.left);
        }
        return root;
    }

    static Node inputData(Node root) {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        while (data != -1) {
            root = insertInBST(data, root);
            data = sc.nextInt();
        }
        return root;
    }

    static Node InOrderSuccessor(Node root, int x) {
        Node successor = null;
        while (root != null) {
            if (root.data <= x) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

    static void InorderTraverse(Node root) {
        if (root == null) {
            return;
        }

        InorderTraverse(root.left);
        System.out.print(root.data + " ");
        InorderTraverse(root.right);
    }

    static Node maxValue(Node root) {
        Node temp = root.left;
        while (root.left != null) {
            temp = root.left;
        }
        return temp;
    }

    static Node deleteFromBst(Node root, int x) {
        if (root == null) {
            return root;
        }
        if (root.data == x) {
            // 0 child
            if (root.left == null && root.right == null) {
                root = null;
                return root;
            }
            // 1 child , left or right
            if (root.left != null && root.right == null) {
                Node temp = root.left;
                root = null;
                return temp;
            }
            if (root.left == null && root.right != null) {
                Node temp = root.right;
                root = null;
                return temp;
            }
            // 2 child
            if (root.left != null && root.right != null) {
                int max = maxValue(root.left).data;
                root.data = max;
                root.left = deleteFromBst(root.left, max);
                return root;
            }
        } else if (root.data > x) {
            root.left = deleteFromBst(root.left, x);
            return root;
        } else {
            root.right = deleteFromBst(root.right, x);
            return root;
        }
        return root;
    }

    static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node n = q.peek();
            q.poll();
            if (n == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                System.out.print(n.data + " ");
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Node root = null;
        System.out.println("Enter Data: ");
        root = inputData(root);
        System.out.println("Printing level order = ");
        levelOrder(root);
        // System.out.println("Printing Inorder = ");
        // InorderTraverse(root);
        // Node succ = InOrderSuccessor(root, 30);
        // System.out.println("Successor is "+succ.data);
        root = deleteFromBst(root, 30);
        System.out.println("Printing level order after deletion = ");
        levelOrder(root);
    }
}
