import java.util.*;

public class B {
    
    public static long solve(int N, int M, int[] size, int[] taste) {
        // Create pairs of size and taste
        int[][] dishes = new int[N][2];
        for (int i = 0; i < N; i++) {
            dishes[i][0] = size[i];
            dishes[i][1] = taste[i];
        }
        
        // Sort dishes based on taste in descending order
        Arrays.sort(dishes, (a, b) -> Integer.compare(b[1], a[1]));
        
        // Priority queue to maintain the largest sizes
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        long maxSatisfaction = 0;
        
        for (int i = 0; i < N; i++) {
            // If the max heap is full, remove the smallest size to make room
            if (maxHeap.size() == M) {
                sum -= maxHeap.poll();
            }
            // Add the current size to the max heap and update the sum
            maxHeap.offer(dishes[i][0]);
            sum += dishes[i][0];
            // Calculate the satisfaction and update the maximum satisfaction
            maxSatisfaction = Math.max(maxSatisfaction, sum * dishes[i][1]);
        }
        
        return maxSatisfaction;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases
        
        while (T-- > 0) {
            int N = sc.nextInt(); // Number of dishes
            int M = sc.nextInt(); // Maximum number of dishes that can be eaten
            
            int[] size = new int[N];
            int[] taste = new int[N];
            
            for (int i = 0; i < N; i++) {
                size[i] = sc.nextInt();
            }
            
            for (int i = 0; i < N; i++) {
                taste[i] = sc.nextInt();
            }
            
            System.out.println(solve(N, M, size, taste));
        }
        
        sc.close();
    }
}
