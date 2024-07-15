import java.util.*;

public class pairk {

    public static void kSmallestPair(int[] A, int[] B, int K) {
        int n = A.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];  
            else if (A[a[1]] != A[b[1]])
                return A[a[1]] - b[a[1]];  
            else
                return B[a[2]] - b[a[2]];  
        });
 
        Set<String> mySet = new HashSet<>();
 
        pq.offer(new int[]{A[0] + B[0], 0, 0});
        mySet.add("0,0");
 
        int count = 0;
        while (count < K && !pq.isEmpty()) {
         
            int[] temp = pq.poll();
            int i = temp[1], j = temp[2];
            System.out.println("(" + A[i] + ", " + B[j] + ")");  
 
            boolean flag = false;
            if (i + 1 < n) {
                int sum = A[i + 1] + B[j];
               
                String key = (i + 1) + "," + j;

             
                if (!mySet.contains(key)) {
                    pq.offer(new int[]{sum, i + 1, j});
                    mySet.add(key);
                    flag = true;
                }
            }
 
            if (j + 1 < B.length) {
                
                int sum = A[i] + B[j + 1];
                String key = i + "," + (j + 1);

               
                if (!mySet.contains(key)) {
                    pq.offer(new int[]{sum, i, j + 1});
                    mySet.add(key);
                    flag = true;
                }
            }
            // System.out.println(mySet);
            if (!flag) {
                break;
            }
            count++;
        }
        System.err.println(count);
    }

    public static void main(String[] args) {
        int[] A = {2,3,5};
        int[] B = {4,6,8};
        int K = 3;
        kSmallestPair(A, B, K);
    }
}
