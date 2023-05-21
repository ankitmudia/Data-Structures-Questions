/**
 * InnerminimizeTheHeight
 */
/**
 * approach - 
 * So the approach is pretty simple,

First, we sort the array A

Then we initialize the answer with ans = A[n-1]-A[0], the current minimal max difference between the heights of tower.

Now, in order to maximize the difference between the heights, we will perform the below steps

Since A[0] becomes minimum after sorting, so adding k pushes it towards maximum. Also, we subtract k from A[i] to get any other smaller possible value(minPossible). Similarly, A[n-1] becomes maximum, so subtracting k pushes it towards minimum. Again, we add k to A[i] to get any other maximum possible value(maxPossible).

Next we iterate over the array A[] from 1 to n-1 and implement the above logic and update our ans with min(ans,maxPossible-minPossible) at the end of each iteration.

Here we also check for negative heights before updating ans, i.e. if(minPossible<0) then we do not update ans for that iteration.
 * 
 */
public class InnerminimizeTheHeight {

    public static void main(String[] args) {
        Arrays.sort(arr);
        int ans = arr[n-1] - arr[0];
        int small = arr[0]+k;
        int large = arr[n-1]-k;
        int min;
        int max;
        
        for(int i=0;i<n-1;i++) {
            min = Math.min(small, arr[i+1]-k);
            max = Math.max(large, arr[i]+k);
            if(min<0) {
                continue;
            }
            ans = Math.min(ans, max-min);
        }
        return ans;
    }
}
