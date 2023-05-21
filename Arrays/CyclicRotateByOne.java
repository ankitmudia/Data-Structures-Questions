/**
 * CyclicRotateByOne
 */
/**
 * arr[i] = 0;
 * Swap last element with arr[i],
 * increment i by one;
 */

public class CyclicRotateByOne {

    public static void main(String[] args) {
        
        int[] arr = {1, 2, 3, 4, 5};
        
        int i=0;
        int j=arr.length-1;
        while(i<j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
        }

        for(int k=0;k<arr.length-1;k++) {
            System.out.print(arr[k]+" ");
        }

    }
}