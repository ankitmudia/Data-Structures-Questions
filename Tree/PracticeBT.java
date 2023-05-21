import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.Map;

public class PracticeBT {
    public class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node buildBinaryTree(Node root) {
        System.out.println("Enter Data:");
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();

        root = new Node(value);

        if (value == -1) {
            return null;
        }

        System.out.println("Enter data for left Node: " + root.data);
        root.left = buildBinaryTree(root.left);
        System.out.println("Enter data for right Node: " + root.data);
        root.right = buildBinaryTree(root.right);

        return root;
    }

    void levelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.data + " ");

            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
    }

    int heightOfTree(Node root) {
        // base case
        if (root == null) {
            return 0;
        }

        int leftAns = heightOfTree(root.left);
        int rightAns = heightOfTree(root.right);

        return Math.max(leftAns, rightAns) + 1;
    }

    int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        int lDiameter = diameter(root.left);
        int rDiameter = diameter(root.right);
        int currentNode = heightOfTree(root.left) + heightOfTree(root.right) + 1;
        return Math.max(currentNode, Math.max(rDiameter, lDiameter));
    }

    void inOrder(Node root) {
        // base case
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    void preOrder(Node root) {
        // base case
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    void postOrder(Node root) {
        // base case
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    void mirrorTree(Node root) {
        // base case
        if (root == null) {
            return;
        }

        mirrorTree(root.left);
        mirrorTree(root.right);

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    void leftViewOfTree(Node root, ArrayList<Integer> leftViewResult, int level) {
        if (root == null) {
            return;
        }

        if (level == leftViewResult.size()) {
            leftViewResult.add(root.data);
        }

        leftViewOfTree(root.left, leftViewResult, level + 1);
        leftViewOfTree(root.right, leftViewResult, level + 1);
    }

    void rightViewOfTree(Node root, ArrayList<Integer> rightViewResult, int level) {
        if (root == null) {
            return;
        }

        if (level == rightViewResult.size()) {
            rightViewResult.add(root.data);
        }

        rightViewOfTree(root.right, rightViewResult, level + 1);
        rightViewOfTree(root.left, rightViewResult, level + 1);
    }

    static class Pair {
        int horizontalDistance;
        Node node;

        Pair(int horizontalDistance, Node root) {
            this.horizontalDistance = horizontalDistance;
            this.node = root;
        }
    }

    static class Pair2 {
        boolean flag;
        int data;

        Pair2(boolean flag, int data) {
            this.flag = flag;
            this.data = data;
        }
    }

    void verticalOrderTraversal(Node root) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return;
        }

        q.add(new Pair(0, root));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if (hm.containsKey(curr.horizontalDistance)) {
                hm.get(curr.horizontalDistance).add(curr.node.data);
            } else {
                ArrayList<Integer> tempList = new ArrayList<>();
                tempList.add(curr.node.data);
                hm.put(curr.horizontalDistance, tempList);
            }

            if (curr.node.left != null) {
                q.add(new Pair(curr.horizontalDistance - 1, curr.node.left));
            }
            if (curr.node.right != null) {
                q.add(new Pair(curr.horizontalDistance + 1, curr.node.right));
            }
        }

        System.out.println(hm);
        for (Map.Entry<Integer, ArrayList<Integer>> entry : hm.entrySet()) {
            ans.addAll(entry.getValue());
        }

    }

    void topView(Node root) {
        Map<Integer, Integer> hm = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair curr = q.poll();

            if (!hm.containsKey(curr.horizontalDistance)) {
                int data = curr.node.data;
                hm.put(curr.horizontalDistance, data);
            }
            if (curr.node.left != null) {
                q.add(new Pair(curr.horizontalDistance - 1, root.left));
            }
            if (curr.node.right != null) {
                q.add(new Pair(curr.horizontalDistance + 1, root.right));
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> i : hm.entrySet()) {
            // System.out.print(i.getValue() + " ");
            ans.add(i.getValue());
        }
        System.out.println(ans);
    }

    void bottomView(Node root) {
        Map<Integer, Integer> hm = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair curr = q.poll();

            int data = curr.node.data;
            hm.put(curr.horizontalDistance, data);
            if (curr.node.left != null) {
                q.add(new Pair(curr.horizontalDistance - 1, root.left));
            }
            if (curr.node.right != null) {
                q.add(new Pair(curr.horizontalDistance + 1, root.right));
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> i : hm.entrySet()) {
            System.out.print(i.getValue() + " ");
        }
    }
    Pair2 sumTree(Node root) {
        if(root == null) {
            Pair2 p = new Pair2(true, 0);
            return p;
        }

        if(root.left == null && root.right == null) {
            Pair2 p = new Pair2(true, root.data);
            return p;
        }

        Pair2 leftAns = sumTree(root.left);
        Pair2 rightAns = sumTree(root.right);
        
        boolean left = leftAns.flag;
        boolean right = rightAns.flag;

        boolean currAns = root.data == leftAns.data + rightAns.data;

        Pair2 ans = new Pair2(false, 0);
        if(left && right && currAns) {
            ans.flag = true;
            ans.data = 2*root.data;
        } else {
            ans.flag = false;
        }
        return ans;
    }
    void zigZag(Node root) {
        if(root == null) {
            return;
        }
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        while(!q.isEmpty()) {
            int size = q.size();
            int[] temp = new int[size];

            for(int i=0;i<size;i++) {
                Node element = q.poll();
                // int index = leftToRight ? i : size-i-1;
                temp[leftToRight ? i : size-i-1] = element.data;

                if(element.left != null) {
                    q.add(element.left);
                }
                if(element.right != null) {
                    q.add(element.right);
                }
            }
            leftToRight = !leftToRight;
            for(int i=0;i<temp.length;i++) {
                result.add(temp[i]);
            }
        }
        System.out.println("Zig Zag Traversal: "+result);
    }
    void traverseLeft(Node root, ArrayList<Integer> al) {
        if((root == null) || (root.left == null && root.right == null)) {
            return;
        }
        al.add(root.data);
        if(root.left != null) {
            traverseLeft(root.left, al);
        } else {
            traverseLeft(root.right, al);
        }
    }

    void traverseLeaf(Node root, ArrayList<Integer> al) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            al.add(root.data);
        }

        traverseLeaf(root.left, al);
        traverseLeaf(root.right, al);
    }

    void traverseRight(Node root, ArrayList<Integer> al) {
        if((root == null) || (root.left == null && root.right == null)) {
            return;
        }
        if(root.right != null) {
            traverseRight(root.right, al);
        } else {
            traverseRight(root.left, al);
        }
        al.add(root.data);
    }

    void boundary(Node root) {
        ArrayList<Integer> al = new ArrayList<>();
        if(root == null) {
            return;
        }
        al.add(root.data);

        traverseLeft(root.left, al);
        traverseLeaf(root.left, al);
        traverseLeaf(root.right, al);
        traverseRight(root.right, al);
        System.out.println(al);
    }
    Node LCA(Node root, int n1, int n2) {
        if(root == null) {
            return null;
        }

        if(root.data == n1 || root.data == n2) {
            // System.out.println(root.data);
            return root;
        }

        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);
        if(left != null && right != null) {
            return root;
        }

        if(left != null && right == null) {
            return left;
        }
        if(right != null && left == null) {
            return right;
        }
        else {
            return null;
        }
    }

    public static void main(String[] args) {
        // data -> 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
        PracticeBT I = new PracticeBT();
        Node root = null;
        root = I.buildBinaryTree(null);
        System.out.println("Level Order:");
        I.levelOrderTraversal(root);
        // System.out.println("In Order:");
        // I.inOrder(root);
        // System.out.println("Pre Order:");
        // I.preOrder(root);
        // System.out.println("Post Order:");
        // I.postOrder(root);
        // System.out.println("height: "+I.heightOfTree(root));
        // System.out.println("diameter: "+I.diameter(root));
        // I.mirrorTree(root);
        // System.out.println("Level Order:");
        // I.levelOrderTraversal(root);
        // ArrayList<Integer> leftViewResult = new ArrayList<>();
        // I.leftViewOfTree(root, leftViewResult, 0);
        // System.out.println("Left view: "+leftViewResult);
        // ArrayList<Integer> rightViewResult = new ArrayList<>();
        // I.rightViewOfTree(root, rightViewResult, 0);
        // System.out.println("Right View: "+rightViewResult);
        // I.verticalOrderTraversal(root);
        // System.out.println("Top View: ");
        // I.topView(root);
        // System.out.println("Bottom View: ");
        // I.bottomView(root);
        // Sum Tree
        // Pair2 ans = new Pair2(false, 0);
        // ans = I.sumTree(root);
        // System.out.println(ans.flag+" "+ans.data);
        // Zig Zag traversal
        // I.zigZag(root);
        // Boundary Traversal
        // I.boundary(root);
        System.out.println();
        Node ans = I.LCA(root, 3, 4);
        System.out.println("LCA "+ans.data);
    }
}
