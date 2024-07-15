
import java.io.*;
import java.util.*;

class mintimetofillNslots{
    public static void minTime(int arr[], int N, int K) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[N + 1];
        int time = 0;
        
        for (int i = 0; i < K; i++) {
            q.add(arr[i]);
            vis[arr[i]] = true;
        }
        
        while (q.size() > 0) {
            for (int i = 0; i < q.size(); i++) {
                int curr = q.poll();
                
                if (curr - 1 >= 1 && !vis[curr - 1]) {
                    vis[curr - 1] = true;
                    q.add(curr - 1);
                }
                
                if (curr + 1 <= N && !vis[curr + 1]) {
                    vis[curr + 1] = true;
                    q.add(curr + 1);
                }
            }
            time++;
        }
        
        System.out.println(time - 1);
    }
    
    public static void main(String[] args) {
        int N = 10;
        int arr[] = {1,2,3,4,5};
        int K = arr.length;
        minTime(arr, N, K);
    }
}

