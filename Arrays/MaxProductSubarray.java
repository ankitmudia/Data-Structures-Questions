public class MaxProductSubarray {
    public static void main(String[] args) {
        int[] arr = {-8, 5, 3, 1, 6};
        int n = arr.length;

        int prod = 1;
        int maxProd = 1;
        for(int i=0;i<n;i++) {
                prod = prod*arr[i];
            if(prod == 0){
                prod = 1;
            }
            if(arr[i] > maxProd) {
                maxProd = prod;
            }
        }

        prod = 1;
        for(int i=n-1;i>=0;i--) {
            prod = prod*arr[i];
            if(arr[i] == 0){
                prod = 1;
            }
            if(prod > maxProd) {
                maxProd = prod;
            }
        }
        System.out.println(maxProd);
    }
}
