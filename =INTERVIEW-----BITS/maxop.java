public class maxop {
    static class Solution {
        public int minOperations(int k) {
            int[] nums = {1}; // Initialize array with only 1
            int operations = 0;
            int sum = 1;

            double ceilResult = Math.ceil((double) k / 3);
            double check=(double) k / 3;
             
            if(k==1)return 0;
            if(k==2)return 1;
            if(k==3)return 2;

            
         




            return (double) k % 3 >=2 ?(int) ceilResult+1: (int) ceilResult ;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 11;
        System.out.println(solution.minOperations(k)); // Output should be 5
    }
}
