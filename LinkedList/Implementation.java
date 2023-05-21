/**
 * Implementation
 */

public class Implementation {
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

    // inserting at a specified position of linked list
    void insertAtPosition(int pos, int data) {
        // insert at start
        if (pos == 1) {
            insertAtHead(data);
            return;
        }

        Node temp = head;
        int count = 1;
        // creating node which is to be inserted in the middle of linked list
        Node nodeToInsert = new Node(data);
        while (count < pos - 1) {
            temp = temp.next;
            count++;
        }

        // inserting at last
        if (temp.next == null) {
            insertAtTail(data);
            return;
        }

        nodeToInsert.next = temp.next;
        temp.next = nodeToInsert;
    }

    // Inserting at end of linked list
    void insertAtTail(int data) {
        Node newNode = new Node(data);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void deleteNode(int position) {
        // deleting start node
        if (position == 1) {
            head = head.next;
        }
        // deleting middle or last node
        else {
            Node curr = head;
            Node prev = null;
            int count = 1;
            while (count <= position) {
                prev = curr;
                curr = curr.next;
                count++;
            }
            prev.next = curr.next;
        }
    }

    static void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Implementation I = new Implementation();
        I.insertAtHead(4);
        I.insertAtHead(3);
        I.insertAtHead(2);
        I.insertAtHead(1);
        // I.insertAtTail(5);
        // I.insertAtTail(0);
        // I.insertAtPosition(3, 14);
        // I.insertAtPosition(2, 9);
        // I.insertAtPosition(5, 0);
        // I.deleteNode(1);
        printLL();
    }
}