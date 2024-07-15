import java.util.ArrayList;

public class Q49_Burst_Balloons {
    public static int f(int i, int j, ArrayList<Integer> list){
        if(i > j) return 0;

        int maxi = Integer.MIN_VALUE;
        
        for(int idx = i; idx <= j; idx++){
            int count = list.get(i-1) * list.get(idx) * list.get(j+1) + f(i, idx-1, list) + f(idx+1, j, list);
            maxi = Math.max(maxi, count);
        }

        return maxi;
    }
    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        int n = nums.length;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        for(int i = 0; i < n; i++) list.add(nums[i]);
        list.add(1);

        System.out.println(f(1, n, list)); 
    }
}
