/**
 * IntersectionOfLinkedList
 */
/*
 * approach - 
 * using two pointers
 * one on first list
 * second on second list
 * see if the data is equal, create new node of that data
 * else increment which ever's data is small 
 */
public class IntersectionOfLinkedList {

    // public static Node findIntersection(Node head1, Node head2)
    // {
    //     // code here.
    //     Node one = head1;
    //     Node two = head2;
    //     Node nodeToReturn = new Node(0);
    //     Node prev = null;
    //     Node temp = nodeToReturn;
    //     while(one != null && two != null) {
    //         if(one.data == two.data) {
    //             temp.next = new Node(one.data);
    //             one = one.next;
    //             two = two.next;
    //             temp = temp.next;
    //         } else if(one.data < two.data) {
    //             prev = one;
    //             one = one.next;
    //             prev = prev.next;
    //         } else if(two.data < one.data){
    //             prev = two;
    //             two = two.next;
    //             prev = prev.next;
    //         }
    //     }
    //     //returning next of nodeToReturn because the head node contains 0;
    //     return nodeToReturn.next;
    // }
}