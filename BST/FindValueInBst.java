/**
 * BST
 */
public class FindValueInBst {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            // Assign data to the new node, set left and right children to null
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node root;

    public void insert(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
            return;
        } else {
            Node current = root;
            Node parent = null;
            while (true) {
                parent = current;
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }

                }
            }
        }
    }

    public int findValue(Node node, int key) {
        if (node == null) {
            return -1;
        }
        if (node.data == key) {
            return node.data;
        }

        if (node.data < key) {
            return findValue(node.right, key);
        }

        return findValue(node.left, key);

    }

    public void TraverseInorder(Node node) {

        // Check whether tree is empty
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        } else {

            if (node.left != null)
                TraverseInorder(node.left);
            System.out.print(node.data + " ");
            if (node.right != null)
                TraverseInorder(node.right);

        }
    }

    public static void main(String[] args) {
        FindValueInBst b = new FindValueInBst();
        b.insert(50);
        b.insert(30);
        b.insert(70);
        b.insert(60);
        b.insert(10);
        b.insert(90);

        b.TraverseInorder(b.root);
        int result = b.findValue(b.root, 60);
        System.out.println();
        System.out.println(result);
    }
}