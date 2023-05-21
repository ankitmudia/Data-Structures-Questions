
/*
 * approach 1 brute force O(n)^2;
 * Create two arrays indegree and outdegree, to store the indegree and outdegree
Run a nested loop, the outer loop from 0 to n and inner loop from 0 to n.
For every pair i, j check if i knows j then increase the outdegree of i and indegree of j.
For every pair i, j check if j knows i then increase the outdegree of j and indegree of i.
Run a loop from 0 to n and find the id where the indegree is n-1 and outdegree is 0.
 */

/*
 * approach 2 optimised using stack
 Create a stack and push all the ids in the stack.
Run a loop while there are more than 1 element in the stack.
Pop the top two elements from the stack (represent them as A and B)
If A knows B, then A can’t be a celebrity and push B in the stack.
Else if A doesn’t know B, then B can’t be a celebrity push A in the stack.
Assign the remaining element in the stack as the celebrity.
Run a loop from 0 to n-1 and find the count of persons who knows
the celebrity and the number of people whom the celebrity knows.
If the count of persons who knows the celebrity is n-1 and
the count of people whom the celebrity knows is 0 then return the id of the celebrity else return -1.
 */
import java.util.Stack;

public class CelebrityProblem {

    static int iterative(int[][] M, int n) {
        int[] in = new int[n];
        int[] out = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // knowing condition
                if (M[i][j] == 1) {
                    in[j]++;
                    out[i]++;
                }
            }
        }

        // check if he is celebrity
        for (int i = 0; i < n; i++) {
            if ((in[i] == n - 1) && (out[i] == 0)) {
                return i;
            }
        }
        return -1;
    }

    static boolean knows(int M[][], int a, int b, int n) {
        if (M[a][b] == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] M = { { 0, 1, 0 },
                { 0, 0, 0 },
                { 0, 1, 0 } };
        // brute force iterative approach
        // System.out.println(iterative(M, n));

        // solveUsingStack
        Stack<Integer> s = new Stack<>();
        // push all elements in stack
        for (int i = 0; i < n; i++) {
            s.push(i);
        }

        while (s.size() > 1) {
            int a = s.peek();
            s.pop();
            int b = s.peek();
            s.pop();

            if (knows(M, a, b, n)) {
                s.push(b);
            } else {
                s.push(a);
            }
        }

        // single element in stack(Potential celebrity, verify it)
        int candidate = s.peek();
        boolean rowCheck = false;
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            if (M[candidate][i] == 0) {
                zeroCount++;
            }
        }
        // all zero check
        if (zeroCount == 0) {
            rowCheck = true;
        }

        // check coloum
        boolean colCheck = false;
        int oneCount = 0;
        for (int i = 0; i < n; i++) {
            if (M[i][candidate] == 1) {
                oneCount++;
            }
        }

        if (oneCount == n - 1) {
            colCheck = true;
        }

        // if (rowCheck == true && colCheck == true) {
        System.out.println(candidate);
        // }
    }
}
