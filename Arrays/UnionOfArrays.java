/**
 * InnerUnionOfArrays
 */
/**
 * BruteForce approach for union - 
 * use 2 index i and j for arr1 and arr 2
 * if arr1[i] is smaller than arr2[j], put arr1[i] into another array and increment i,
 * if arr2[j] is smaller than arr1[i], put arr2[j] into another array and increment j,
 * if both are equal, put any and increment both,
 * 
 * optimised - 
 * using hashSet-
 * hashSet stores only unique elements in itself;
*/

public class InnerUnionOfArrays {
public static void main(String[] args) {
    HashSet<Integer> map = new HashSet<Integer>();
        
        for(int i=0;i<n;i++) {
            map.add(a[i]);
        }
        for(int i=0;i<m;i++) {
            map.add(b[i]);
        }
        
        return map.size();
}
    
}
