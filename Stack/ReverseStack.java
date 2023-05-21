import java.util.Stack;

public class ReverseStack {

    static void insertAtBottom(Stack<Integer> st, int element) {
        if (st.isEmpty()) {
            st.push(element);
            return;
        }

        int top = st.pop();
        insertAtBottom(st, element);
        st.push(top);
    }

    static void reverseStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }

        int element = st.pop();
        reverseStack(st);

        insertAtBottom(st, element);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(5);
        st.push(4);
        st.push(3);
        st.push(2);
        st.push(1);
        System.out.println("Original " + st);
        reverseStack(st);
        System.out.println("Reversed " + st);
    }
}
