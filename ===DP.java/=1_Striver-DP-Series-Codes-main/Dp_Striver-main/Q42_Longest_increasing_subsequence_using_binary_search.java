import java.util.*;
public class Q42_Longest_increasing_subsequence_using_binary_search {
    
    public static void main(String[] args) {
        
        int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
        int n = arr.length;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        int len = 1;

        for(int i = 1; i < n; i++){
            if(arr[i] > list.get(list.size() - 1)) list.add(arr[i]);
            else{
                // function for the idx where we can rewrite the arr[i]
                // and add arr[i] at that idx of list
            }
        }

        System.out.println(len);

    }

}
