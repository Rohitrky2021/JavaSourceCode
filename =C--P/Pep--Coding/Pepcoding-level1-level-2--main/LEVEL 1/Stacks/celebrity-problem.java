import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public class Solution { // Without use of Stack
        public int findCelebrity(int[][] M, int n) {
            int candidate = 0;
            
            // Find a candidate who may be a celebrity
            for (int i = 1; i < n; i++) {
                if (M[candidate][i] == 1) {
                    candidate = i;
                }
            }
            
            // Check if the candidate is a celebrity
            for (int i = 0; i < n; i++) {
                if (i != candidate && (M[candidate][i] == 1 || M[i][candidate] == 0)) {
                    return -1; // Not a celebrity
                }
            }
            
            return candidate;
        }
    }
    

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            st.push(i);
        }
        
        while(st.size() >= 2){
            int i = st.pop();
            int j = st.pop();
            
            if(arr[i][j] == 1){
                st.push(j);
            } else {
                st.push(i);
            }
        }
        
        int pot = st.pop();
        for(int i = 0; i < arr.length; i++){
            if(i != pot){
                if(arr[i][pot] == 0 || arr[pot][i] == 1){
                    System.out.println("none");
                    return;
                }
            }
        }
        
        System.out.println(pot);
    }

}