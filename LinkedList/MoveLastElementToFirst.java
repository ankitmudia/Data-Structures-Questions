public class MoveLastElementToFirst {
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

    void moveLast() {
        Node temp = head;
        Node prev = head;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        temp.next = head;
        head = temp;
    }

    public static void main(String[] args) {
        MoveLastElementToFirst I = new MoveLastElementToFirst();
        I.insertAtHead(4);
        I.insertAtHead(2);
        I.insertAtHead(2);
        I.insertAtHead(5);
        printLL();
        I.moveLast();
        printLL();
    }
}
