/**
 * DoublyImpl
 */
public class DoublyImpl {
    static Node head;

    class Node {
        int data;
        Node prev;
        Node next;

        // constructor
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // inserts at first position
    void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        newNode.prev = null;

        if (head != null) {
            head.prev = newNode;
        }

        head = newNode;
    }

    // inserts at end of LL
    void insertAtTail(int data) {
        if (head == null) {
            insertAtHead(data);
        } else {
            Node newNode = new Node(data);
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
            temp = newNode;
        }
    }

    void insertAtPos(int pos, int data) {
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
        temp.prev = nodeToInsert;
        temp.next = nodeToInsert;
        nodeToInsert.prev = temp;
    }

    void deleteNode(int position) {
        // deleting start node
        if (position == 1) {
            Node temp = head;
            temp.next.prev = null;
            head = temp.next;
            temp.next = null;
        }
        // deleting middle or last node
        else {
            Node curr = head;
            Node prev = null;
            int count = 1;
            while (count < position) {
                prev = curr;
                curr = curr.next;
                count++;
            }
            curr.prev = null;
            prev.next = curr.next;
            curr.next = null;
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

    static int getLength() {
        Node temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public static void main(String[] args) {
        DoublyImpl d = new DoublyImpl();
        d.insertAtHead(10);
        d.insertAtHead(11);
        d.insertAtHead(12);
        d.insertAtHead(13);
        d.insertAtHead(14);
        d.insertAtTail(9);
        printLL();
        // d.insertAtPos(2, 100);
        // d.insertAtPos(1, 101);
        // d.insertAtPos(9, 102);
        d.deleteNode(6);
        printLL();
        int len = getLength();
        System.out.println("length = " + len);
    }
}