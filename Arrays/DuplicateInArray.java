/**
 * InnerDuplicateInArray
 */
/**
 * Approach
 * we can use a hashSet
 * HashSet only stores unique elements in it,
 * so while adding we can check if it already exists, then it is duplicate,
 * else we will add it in the set
 */
public class InnerDuplicateInArray {

    public static void main(String[] args) {
        
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++) {
            if(m.containsKey(arr[i])) {
                m.put(arr[i], m.get(arr[i])+1);
            }
            else {
                m.put(arr[i], 1);
            }
        }
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(Map.Entry<Integer,Integer> entry:m.entrySet()){
            if(entry.getValue() > 1) {
                    a.add(entry.getKey());
            }
        }
        if(a.isEmpty()) {
            a.add(-1);
        }
        Collections.sort(a);
        return a;
    }
}