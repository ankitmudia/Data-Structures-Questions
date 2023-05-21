/**
 * RemoveDuplicatesInSorted
 */
/*
 * Algorithm: Traverse the list from the head (or start) node. While traversing,
 * compare each node with its next node. If the data of the next node is the
 * same as the current node then delete the next node. Before we delete a node,
 * we need to store the next pointer of the node
 */
public class RemoveDuplicatesInSorted {
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

    static void removeDup() {
        if (head.next == null) {
            return;
        }
        Node curr = head.next;
        Node prev = head;

        while (curr != null) {
            if (prev.data == curr.data) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
    }

    public static void main(String[] args) {
        RemoveDuplicatesInSorted I = new RemoveDuplicatesInSorted();
        I.insertAtHead(8);
        I.insertAtHead(7);
        I.insertAtHead(6);
        I.insertAtHead(6);
        I.insertAtHead(5);
        I.insertAtHead(4);
        I.insertAtHead(2);
        I.insertAtHead(2);
        printLL();
        removeDup();
        printLL();
    }
}