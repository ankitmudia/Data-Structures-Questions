/**
 * ReverseKGroups
 */
/*
 * Reverse the first sub-list of size k. While reversing keep track of the next
 * node and previous node. Let the pointer to the next node be next and pointer
 * to the previous node be prev. See this post for reversing a linked list.
 * head->next = reverse(next, k) ( Recursively call for rest of the list and
 * link the two sub-lists )
 * Return prev ( prev becomes the new head of the list (see the diagrams of an
 * iterative method of this post )
 */
public class ReverseKGroups {
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

    static Node rev(Node p, int k) {
        Node forward = null;
        Node curr = p;
        int count = 0;
        Node prev = null;
        while (curr != null && count < k) {
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
            count++;
        }
        if (forward != null) {
            p.next = rev(forward, k);
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseKGroups I = new ReverseKGroups();
        I.insertAtHead(8);
        I.insertAtHead(7);
        I.insertAtHead(6);
        I.insertAtHead(5);
        I.insertAtHead(4);
        I.insertAtHead(2);
        I.insertAtHead(2);
        I.insertAtHead(1);
        printLL();
        head = rev(head, 4);
        System.out.println("After reverse ");
        printLL();
    }
}