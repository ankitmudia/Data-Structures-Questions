/*
 * approach is simple, get inorder of tree, sort it
 * then make tree from that sorted inorder
 */
import java.util.ArrayList;

public class BinaryTreeToBST {

    void getInorder(Node root, ArrayList<Integer> al) {
        if(root == null) {
            return;
        }
        
        getInorder(root.left, al);
        al.add(root.data);
        getInorder(root.right, al);
    }
    
    Node BST(ArrayList<Integer> al, int l, int h) {
        if(l > h) {
            return null;
        }
        int mid = (l+h+1)/2;
        Node root = new Node(al.get(mid));
        
        root.left = BST(al, l, mid-1);
        root.right = BST(al, mid+1, h);
        return root;
        
    }
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
       getInorder(root, al);
       Collections.sort(al);
       return BST(al, 0, al.size()-1)
    }
}
