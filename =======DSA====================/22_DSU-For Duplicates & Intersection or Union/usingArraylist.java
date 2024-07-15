public class usingArraylist {

    // nlogn, constant memory solution without using Set


    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            List<Integer> result = new ArrayList();
            if(nums1 == null || nums2 == null)
                return result.stream().mapToInt(Integer::intValue).toArray();
            
            Arrays.sort(nums1);
            Arrays.sort(nums2);
         
            for(int i=0, j=0; i<nums1.length && j<nums2.length; ){
                if(nums1[i]==nums2[j]){
                    int size = result.size();
                    i++;j++; 
                    if(size != 0 && result.get(size-1)==nums1[i-1])
                        continue;
                    result.add(nums1[i-1]);
                  
                } else if(nums1[i]<nums2[j])
                    i++;
                else
                    j++;
            }
            return result.stream().mapToInt(Integer::intValue).toArray();
            
        }
    }
    
}
