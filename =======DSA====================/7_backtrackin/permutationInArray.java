import java.util.*;
public class permutationInArray {

    // https://leetcode.com/problems/permutations-ii/submissions/?envType=daily-question&envId=2023-09-01
    public static void main(String[] args) {
        int num[]={1,1,2};
        List<List<Integer>> result =permute(num);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, current, result);
        return result;
    }

    private static void backtrack(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            // if(!result.contains(current))    //comment this out and check  ones 
            result.add(new ArrayList<>(current));
            return;
        }
 
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                // continue;    //comment this out and check  ones 
            }
            visited[i] = true;
            current.add(nums[i]);// work start for the particular step;
            backtrack(nums, visited, current, result);
            current.remove(current.size() - 1);//backtrack step ;
            visited[i] = false;
        }
    }
}