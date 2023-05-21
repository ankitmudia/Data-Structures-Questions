import java.util.ArrayList;

/**
 * Impl
 */
public class Impl {

    void print(ArrayList<Integer> arr) {
        for(Integer i: arr) {
            System.out.print(i+ " ");
        }
        System.out.println();
    }

    void heapify(ArrayList<Integer> hT, int i) {
    int size = hT.size();
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;
    if (l < size && hT.get(l) > hT.get(largest))
      largest = l;
    if (r < size && hT.get(r) > hT.get(largest))
      largest = r;

    if (largest != i) {
      int temp = hT.get(largest);
      hT.set(largest, hT.get(i));
      hT.set(i, temp);

      heapify(hT, largest);
    }
  }

    void insert(ArrayList<Integer> arr, int num) {
        int size = arr.size();
        if(size == 0) {
            arr.add(num);
        } else {
            arr.add(num);
            for(int i=size/2-1;i>=0;i--) {
                heapify(arr, i);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        // int size = arr.size();
        Impl m = new Impl();
        m.insert(arr, 3);
        m.insert(arr, 4);
        m.insert(arr, 9);
        m.insert(arr, 5);
        m.insert(arr, 2);
        m.print(arr);
    }
}