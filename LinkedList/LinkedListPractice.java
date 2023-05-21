public class LinkedListPractice {

    static Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void insertAtHead(int data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    void insertAtTail(int data) {
        Node newNode = new Node(data);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        Node temp = head;
        int count = 0;
        if (position == 1) {
            insertAtHead(data);
            return;
        }
        while (count < position - 1) {
            temp = temp.next;
            count += 1;
        }
        if (temp.next == null) {
            insertAtTail(data);
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "=>");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    Node reverse() {
        Node curr = head;
        Node forward;
        Node prev = null;
        while (curr != null) {
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }

        return prev;
    }

    void reverseRecursive(Node curr, Node prev) {
        if (curr == null) {
            head = prev;
            return;
        }

        Node forward = curr.next;

        reverseRecursive(forward, curr);
        curr.next = prev;
    }

    void findMiddle() {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle Is: " + slow.data);
    }

    Node reverseInKGroups(Node pointer, int k) {
        Node forward = null;
        Node curr = pointer;
        Node prev = null;
        int count = 0;
        while (curr != null && count < k) {
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
            count++;
        }

        if (forward != null) {
            pointer.next = reverseInKGroups(forward, k);
        }
        return prev;
    }

    void removeDuplicatesFromSortedList() {
        if (head == null) {
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            if (curr.data == curr.next.data) {
                Node next = curr.next.next;
                curr.next.next = null;
                curr.next = next;
            } else {
                curr = curr.next;
            }
        }
    }

    Node sortedInsert(Node head1, int key) {
        if(head1 == null) {
            return null;
        }
        if(key < head1.data) {
            Node temp = new Node(key);
            temp.next = head;
            head1 = temp;
        }
        
        Node temp = head1;
        Node nodeToInsert = new Node(key);
        while(temp != null && temp.next != null) {
            if(temp.data < key && temp.next.data > key) {
                nodeToInsert.next = temp.next;
                temp.next = nodeToInsert;
            }
            System.out.println("aaaaaa"+temp.data);
            if(temp.next == null) {
            }
            temp = temp.next;
        }
        return head1;
    }

    public static void main(String[] args) {
        LinkedListPractice ll = new LinkedListPractice();
        // Insert At Head
        
        // ll.insertAtHead(80);
        // ll.insertAtHead(69);
        // ll.insertAtHead(58);
        // ll.insertAtHead(47);
        // ll.insertAtHead(36);
        // ll.insertAtHead(25);

        ll.insertAtHead(3);
        ll.insertAtHead(1);
        // Insert At Position
        // ll.insertAtPosition(13, 2);
        // ll.insertAtPosition(9, 3);
        // // Insert At Tail
        // ll.insertAtTail(11);
        // ll.insertAtTail(12);
        // ll.insertAtTail(9);
        // // Print Linked List
        // ll.printLL();
        // // Reverse Linked List
        // head = ll.reverse();
        // ll.printLL();

        // // Find Middle of the LL
        // ll.findMiddle();

        // // Reverse Recursively
        // Node curr = head;
        // Node prev = null;
        // ll.reverseRecursive(curr, prev);
        // ll.printLL();

        // // Reverse LL in K Groups
        // head = ll.reverseInKGroups(head, 2);
        ll.printLL();

        // Duplicates in sorted Linked List
        // LinkedListPractice ll2 = new LinkedListPractice();
        // ll2.insertAtHead(1);
        // ll2.insertAtHead(1);
        // ll2.insertAtTail(2);
        // ll2.insertAtTail(2);
        // ll2.insertAtTail(3);
        // ll2.printLL();
        // ll2.removeDuplicatesFromSortedList();
        // ll2.printLL();
        head = ll.sortedInsert(head, 11);
        ll.printLL();
    }
}
