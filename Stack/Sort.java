import java.util.Stack;

/**
 * Sort
 */
public class Sort {
    static void insertInSortedOrder(Stack<Integer> st, int element) {
        if (st.isEmpty() || st.peek() < element) {
            st.push(element);
            return;
        }

        int topElement = st.pop();
        insertInSortedOrder(st, element);
        st.push(topElement);
    }

    static void sortStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }

        int element = st.pop();
        sortStack(st);
        insertInSortedOrder(st, element);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(2);
        st.push(-1);
        st.push(40);
        st.push(41);
        st.push(-4);

        System.out.println("Original " + st);
        sortStack(st);
        System.out.println("Sorted "+ st);
    }
}