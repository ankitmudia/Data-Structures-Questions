
/*
 * Approach - 
 * Follow the steps mentioned below to implement the idea:

Push the first element to stack.
Pick the rest of the elements one by one and follow the following steps in the loop. 
Mark the current element as next.
If the stack is not empty, compare top most element of stack with next.
If next is greater than the top element, Pop element from the stack. next is the next greater element for the popped element.
Keep popping from the stack while the popped element is smaller than next. next becomes the next greater element for all such popped elements.
Finally, push the next in the stack.
After the loop in step 2 is over, pop all the elements from the stack and print -1 as the next element for them
 */
import java.util.Stack;

public class NextGreater {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = { 1, 3, 2, 4 };
        long[] nge = new long[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                nge[st.peek()] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            nge[st.pop()] = -1;
        }

        for (int i = 0; i < nge.length; i++) {
            System.out.print(nge[i] + " ");
        }
    }
}
