public class AddOneToLLAsNumber {
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

    void reverse() {
        Node prev = null;
        Node forward;
        Node curr = head;

        while (curr != null) {
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }

        head = prev;
    }

    void addNum() {
        reverse();
        int carry = 1;
        Node temp = head;
        Node prev = null;

        while (temp != null) {
            int value = temp.data + carry;
            temp.data = value % 10;
            carry = value / 10;
            prev = temp;
            temp = temp.next;
        }
        if (carry != 0) {
            prev.next = new Node(carry);
        }
        reverse();
    }

    public static void main(String[] args) {
        AddOneToLLAsNumber I = new AddOneToLLAsNumber();
        I.insertAtHead(9);
        I.insertAtHead(9);
        I.insertAtHead(9);
        printLL();
        I.addNum();
        printLL();
        // I.reverse();
        // printLL();
    }
}
