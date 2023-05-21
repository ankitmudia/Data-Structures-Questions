/**
 * RecursiveReverseList
 */
public class RecursiveReverseList {
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

    // recursive function for reversing linked list
    static void rev(Node p) {
        if (p.next == null) {
            head = p;
            return;
        }

        rev(p.next);
        Node q = p.next;
        q.next = p;
        p.next = null;
    }

    public static void main(String[] args) {
        RecursiveReverseList I = new RecursiveReverseList();
        I.insertAtHead(4);
        I.insertAtHead(3);
        I.insertAtHead(2);
        I.insertAtHead(1);
        printLL();
        rev(head);
        System.out.println("After reverse ");
        printLL();
    }
}