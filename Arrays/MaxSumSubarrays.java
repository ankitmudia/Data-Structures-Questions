/**
 * InnerMaxSumSubarrays
 */
/**
 * Brute force approach - tc-O(n^2);
 * we will do nested for loop and check sum for every subarray
 * if sum is greater than the maxSum subarray
 * then we will store sum into maxSum
 * 
 * optimised approach is using kadane's algo - tc-O(n);
 * Initialize:
    max_so_far = INT_MIN
    max_ending_here = 0

Loop for each element of the array

  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
  (c) if(max_ending_here < 0)
            max_ending_here = 0
return max_so_far
 */
public class InnerMaxSumSubarrays {
    public static void main(String[] args) {
        // Your code here
        
        //USING KADANE's ALGO
        
        long currSum = 0;
        long maxSum = arr[0];
        
        for(int i=0;i<n;i++) {
            if(currSum >= 0) {
                currSum += arr[i];
            }
            else {
                currSum = arr[i];
            }
            
            if(currSum > maxSum) {
                maxSum = currSum;
            }
        }
        return maxSum;
    }
    
}
