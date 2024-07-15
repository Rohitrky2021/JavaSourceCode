 
import java.util.*;
import java.util.List;

public class SwapTwoNum {
    public static void main(String[] args) {
        ArrayList<Integer> ll = new List<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        System.out.println(ll);
        swap(ll, 1, 3);
        
        Collections.swap(ll, 0, 1);
        
        
        System.out.println(ll);
    }

    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);

     }
}
 
