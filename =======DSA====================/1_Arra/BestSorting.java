public class BestSorting {
    // https://leetcode.com/problems/sort-an-array/description/

    class Solutions {
        public int[] sortArray(int[] nums) {
    
            int i=0;
            int[] ans = new int[nums.length];
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int num : nums) pq.offer(num);
            while(!pq.isEmpty()) ans[i++] = pq.poll();
            return ans;
        }
    }
    
    class Solution {
        public int[] sortArray(int[] a) {
            int max = a[0];
            int min = a[0];
            for (int i = 1; i < a.length; i++) {
                if(max<a[i]){
                    max = a[i];
                }
            }
            for (int i = 1; i < a.length; i++) {
                if(min>a[i]){
                    min = a[i];
                }
            }
            int[] count = new int[max-min+1];
            for(int v:a){
                count[v-min]++;
            }
            int k=0;
            for (int i = 0; i < count.length; i++) {
                while (count[i]>0){
                    a[k] = i+min;
                    k++;
                    count[i]--;
                }
            }
            return a;
        }
    
    }
    
    class Solution {
        public int[] sortArray(int[] nums) {
          int [] cnt=new int [(int)1e5 + 1];
          for(int n : nums){
              cnt[n+(int)5e4]++;
          }
          int index=0;
          for(int i=0;i<=1e5;i++){
              while(cnt[i]--!=0){
                   nums[index++]=i-(int)5e4; 
                            }
          }
          return nums;
        }
    }