import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class J {

    // Pair class
    public static class Pair {
        int x;
        int y;

        Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    // Function to calculate the minimum Manhattan distance
    static void minDist1(ArrayList<Pair> A, int N)
    {
        // ArrayLists to store maximum and minimum of all the four forms
        ArrayList<Integer> V = new ArrayList<>();
        ArrayList<Integer> V1 = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            V.add(A.get(i).x + A.get(i).y);
            V1.add(A.get(i).x - A.get(i).y);
        }

        // Sorting both the ArrayLists
        Collections.sort(V);
        Collections.sort(V1);

        int minimum = Math.min((V.get(V.size() - 1) - V.get(0)),
                               (V1.get(V1.size() - 1) - V1.get(0)));

        System.out.println(minimum);
    }

    static void minDist(ArrayList<Pair> A, int N)
    {
 
        // ArrayLists to store maximum and
        // minimum of all the four forms
        ArrayList<Integer> V = new ArrayList<>();
        ArrayList<Integer> V1 = new ArrayList<>();
 
        for (int i = 0; i < N; i++) {
            V.add(A.get(i).x + A.get(i).y);
            V1.add(A.get(i).x - A.get(i).y);
        }
 
        // Sorting both the ArrayLists
        Collections.sort(V);
        Collections.sort(V1);
 
        int maximum
            = Math.max((V.get(V.size() - 1) - V.get(0)),
                       (V1.get(V1.size() - 1) - V1.get(0)));
 
        System.out.println(maximum);
    }

    class Solution {
        public int minimumDistance(int[][] points) {
            int n = points.length, minMaxDist = Integer.MAX_VALUE;
            ArrayList<int[]> v1 = new ArrayList<>(), v2 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                v1.add(new int[]{points[i][0] + points[i][1], i});
                v2.add(new int[]{points[i][0] - points[i][1], i});
            }
            Collections.sort(v1, (a, b) -> a[0] - b[0]);
            Collections.sort(v2, (a, b) -> a[0] - b[0]);
    
            for (int i = 0; i < n; i++) {
                int[] v1Max = v1.get(n - 1)[1] == i ? v1.get(n - 2) : v1.get(n - 1);
                int[] v2Max = v2.get(n - 1)[1] == i ? v2.get(n - 2) : v2.get(n - 1);
                int[] v1Min = v1.get(0)[1] == i ? v1.get(1) : v1.get(0);
                int[] v2Min = v2.get(0)[1] == i ? v2.get(1) : v2.get(0);
                minMaxDist = Math.min(minMaxDist, Math.max(v1Max[0] - v1Min[0], v2Max[0] - v2Min[0]));
            }
            return minMaxDist;
        }
    }
    int Manhattan(int x[], int y[], int i, int j) {
        return (abs(x[i] - x[j]) + abs(y[i] - y[j]));  
    }
    
    int ManhattanSum(int x[], int y[], int n) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = ans + Manhattan(x, y, i, j);
            }
        }
        return ans;
    }
    

    // Driver Code
    public static void main(String[] args)
    {
        int[][] points1 = {{3,10},{5,15},{10,2},{4,4}};
        int[][] points2 = {{1,1},{1,1},{1,1}};

        // Convert 2D arrays to ArrayList<Pair>
        ArrayList<Pair> pairs1 = new ArrayList<>();
        for (int[] point : points1) {
            pairs1.add(new Pair(point[0], point[1]));
        }

        ArrayList<Pair> pairs2 = new ArrayList<>();
        for (int[] point : points2) {
            pairs2.add(new Pair(point[0], point[1]));
        }

        // Function call
        minDist(pairs1, pairs1.size()); // Output: 12
        minDist(pairs2, pairs2.size()); // Output: 0
    }
}
