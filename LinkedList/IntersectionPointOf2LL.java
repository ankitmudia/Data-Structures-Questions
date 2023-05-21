/**
 * IntersectionPointOf2LL
 */
/*
 * approach -
 * brute force:
 * put each pointer on each of the list,
 * traverse every LL for each Node and check if they intersect.
 * 
 * better approach:
 * Using hashing - traverse the first LL and store the nodes in a hashMap,
 * and then traverse second LL and check if they match.
 * 
 * Optimised approach:
 * Using Two pointers :
 * Initialize two pointers ptr1 and ptr2 at head1 and head2.
 * Traverse through the lists, one node at a time.
 * When ptr1 reaches the end of a list, then redirect it to head2.
 * similarly, when ptr2 reaches the end of a list, redirect it to the head1.
 * Once both of them go through reassigning, they will be equidistant from
 * the collision point
 * If at any node ptr1 meets ptr2, then it is the intersection node.
 * After the second iteration if there is no intersection node it returns NULL.
 */
public class IntersectionPointOf2LL {

    // int intersectPoint(Node head1, Node head2)
    // {
    // // code here
    // Node first = head1;
    // Node second = head2;
    // while(first != second) {
    // if(first.next == null) {
    // first = head2;
    // } else if(second.next == null) {
    // second = head1;
    // }
    // first = first.next;
    // second = second.next;
    // }
    // return first.data;
    // }
}