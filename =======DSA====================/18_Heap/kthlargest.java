
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import javax.swing.RowFilter.ComparisonType;
import javax.xml.stream.StreamFilter;

// by shraddha mam  

class kthlargest {
    static PriorityQueue<Integer> min;
    static int k;

    static List<Integer> getAllKthNumber(int arr[]) {
        List<Integer> list = new ArrayList<>();
        for (int val : arr) {
            if (min.size() < k)
                min.add(val);
            else {
                if (val > min.peek()) {
                    min.poll();
                    min.add(val);
                }
            }
            if (min.size() >= k)
                list.add(min.peek());

            else {
                list.add(-1);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        min = new PriorityQueue<>();
        k = 3;
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        List<Integer> res = getAllKthNumber(arr);
        for (int x : res)
            System.out.print(x + " ");
    }
}
