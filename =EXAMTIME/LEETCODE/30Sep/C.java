public class C {
    public int maxSubarrays(int[] nums) {
        int m=Integer.MAX_VALUE;
        for(int i: nums){
            m=m&i;
        }

        if(m!=0)return 1;
        int r=Integer.MAX_VALUE,s=0;
        isSorted(nums);

        for(int i:nums){
            r= r&i;
            if(r==m){
                s++;
                r=Integer.MAX_VALUE;
            } 
        }
        return s;

    }
        public static boolean isSorted(Integer[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    
}
