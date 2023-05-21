import java.util.HashSet;

public class RemoveDuplicatesInUnsorted {
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
        if (head == null || head.next == null) {
            return;
        }
        HashSet<Integer> h = new HashSet<>();
        Node prev = head;
        Node curr = head;
        while (curr != null) {
            if (h.contains(curr.data)) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                h.add(curr.data);
                prev = curr;
                curr = curr.next;
            }
        }
    }

    public static void main(String[] args) {
        RemoveDuplicatesInUnsorted I = new RemoveDuplicatesInUnsorted();
        // I.insertAtHead(2);
        // I.insertAtHead(2);
        // I.insertAtHead(2);
        // I.insertAtHead(2);
        I.insertAtHead(4);
        I.insertAtHead(2);
        I.insertAtHead(2);
        I.insertAtHead(5);
        printLL();
        removeDup();
        printLL();
    }
}