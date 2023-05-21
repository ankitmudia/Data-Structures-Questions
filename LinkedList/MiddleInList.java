/*
 * Approach-
 * Solved Using two pointers
 * fast and slow
 * increment slow by one
 * increment fast by two
 * when fast reaches end
 * slow will always be at the middle of the linked list
 */
public class MiddleInList {
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

    static void getMiddle() {
        if (head == null || head.next == null) {
            return;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println(slow.data);
    }

    public static void main(String[] args) {
        MiddleInList I = new MiddleInList();
        I.insertAtHead(8);
        I.insertAtHead(7);
        I.insertAtHead(6);
        // I.insertAtHead(6);
        I.insertAtHead(5);
        I.insertAtHead(4);
        I.insertAtHead(2);
        I.insertAtHead(2);
        printLL();
        getMiddle();
    }
}
