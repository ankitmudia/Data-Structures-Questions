import java.util.Stack;

public class PracticeStack {

    int[] arr;
    int top;
    int size;

    PracticeStack(int size) {
        this.size = size;
        this.arr = new int[size];
        this.top = -1;
    }

    void push(int data) {
        if (size - top > 1) {
            arr[++top] = data;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    void pop() {
        if (top >= 0) {
            top--;
        } else {
            System.out.println("Stack Underflow");
        }
    }

    int peek() {
        if (top >= 0 && top < size) {
            return arr[top];
        } else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    static void deleteMiddle(Stack<Integer> st3Integers, int count, int size1) {
        if (st3Integers.isEmpty()) {
            return;
        }
        if (count == size1 / 2) {
            st3Integers.pop();
            return;
        }

        int element = st3Integers.pop();
        deleteMiddle(st3Integers, count + 1, size1);
        st3Integers.push(element);
    }

    static boolean matches(char a, char b) {
        if (a == '(' && b == ')' ||
                a == '{' && b == '}' ||
                a == '[' && b == ']') {
            return true;
        }
        return false;
    }

    static boolean isValidParanthesis(Stack<Character> st, String S) {
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                st.push(ch);
            } else {
                if (!st.isEmpty()) {
                    char top = st.peek();
                    if (matches(top, ch)) {
                        st.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        if (st.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    static void insertAtBottom(Stack<Integer> st, int x) {
        // Base case
        if (st.isEmpty()) {
            st.push(x);
            return;
        }

        int element = st.pop();
        insertAtBottom(st, x);
        st.push(element);
    }

    static void reverseUsingRecursion(Stack<Integer> st) {
        // Base case
        if (st.isEmpty()) {
            return;
        }

        int element = st.pop();
        reverseUsingRecursion(st);

        insertAtBottom(st, element);
    }

    static void sortedInsert(Stack<Integer> st, int element) {
        if(st.isEmpty() || st.peek() < element) {
            st.push(element);
            return;
        }
        int element2 = st.pop();
        sortedInsert(st, element);
        st.push(element2);
    }

    static void sortStack(Stack<Integer> st) {
        //Base case
        if(st.isEmpty()) {
            return;
        }

        int element = st.pop();
        sortStack(st);

        //inserting in sorted way
        sortedInsert(st, element);
    }

    public static void main(String[] args) {

        // Implementation using array;

        PracticeStack st = new PracticeStack(5);
        st.push(13);
        st.push(10);
        st.push(11);
        st.push(12);
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());
        if (st.isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack is not empty");
        }

        // Reverse a string using Stack;
        String str = "Ankit";
        Stack<Character> st2 = new Stack<>();
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            st2.push(charArr[i]);
        }
        for (int i = 0; i < charArr.length; i++) {
            charArr[i] = st2.pop();
        }
        System.out.println(String.valueOf(charArr));

        // Delete middle of Stack;

        Stack<Integer> st3 = new Stack<>();
        st3.push(1);
        st3.push(2);
        st3.push(3);
        st3.push(4);
        st3.push(5);
        System.out.println(st3);
        deleteMiddle(st3, 0, st3.size());
        System.out.println(st3);

        // Valid paranthesis;

        Stack<Character> st4 = new Stack<>();
        String str2 = "{()}";
        System.out.println(isValidParanthesis(st4, str2));

        // Insert At Bottom;
        Stack<Integer> st5 = new Stack<>();
        int elementToBeInsert = 9;
        st5.push(7);
        st5.push(1);
        st5.push(4);
        st5.push(5);
        System.out.println(st5);
        insertAtBottom(st5, elementToBeInsert);
        System.out.println(st5);

        // Reverse a stack using recursion;
        reverseUsingRecursion(st5);
        System.out.println(st5);

        //Sort a stack using recursion;
        Stack<Integer> st6 = new Stack<>();
        st6.push(5);
        st6.push(1);
        st6.push(12);
        st6.push(9);
        st6.push(7);
        st6.push(61);
        System.out.println(st6);
        sortStack(st6);
        System.out.println(st6);
    }
}