/**
 * ReverseList
 */
/*Follow the steps below to solve the problem:

Initialize three pointers prev as NULL, curr as head, and next as NULL.
Iterate through the linked list. In a loop, do the following:
Before changing the next of curr, store the next node 
next = curr -> next
Now update the next pointer of curr to the prev 
curr -> next = prev 
Update prev as curr and curr as next 
prev = curr 
curr = next
 */
public class ReverseList {

    static Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // inserting at start of linked list
    void insertAtHead(int data) {
        // create new node;
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    static void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static Node rev() {
        Node prev = null;
        Node forward;
        Node curr = head;
        while(curr != null) {
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseList I = new ReverseList();
        I.insertAtHead(4);
        I.insertAtHead(3);
        I.insertAtHead(2);
        I.insertAtHead(1);
        printLL();
        head = rev();
        System.out.println("After reverse ");
        printLL();
    }
}