import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class C {
    static List<Integer> maxSumDecreasingSequence(int N, int A[]) { // Changed the method name for clarity
        ArrayList<Integer> elements[] = new ArrayList[N];
        int dp[] = new int[N];
        for(int i=0; i<N; i++){
            dp[i] = A[i];
            ArrayList<Integer> temp = new ArrayList<>();
            elements[i] = temp;
        }
        elements[0].add(A[0]);
        ArrayList<Integer> ans = elements[0];
        int max = A[0];
        for(int i=1; i<N; i++){
            int currMax = -1;
            for(int j=0; j<i; j++){
                if(A[j] > A[i] && dp[i] < A[i] + dp[j]){ // Changed the condition to check for a decreasing subsequence
                    dp[i] = A[i] + dp[j];
                    currMax = j;
                }
            }
            if(currMax != -1)
                elements[i].addAll(elements[currMax]);
            elements[i].add(A[i]);
            if(max < dp[i]){
                max = dp[i];
                ans = elements[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int N = 9;
        int A[] = {-1,-2,-3,-4,5, 4, 3, 6, 7};
        
        List<Integer> result = maxSumDecreasingSequence(N, A);
        
        System.out.println("Maximum sum decreasing subsequence:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
