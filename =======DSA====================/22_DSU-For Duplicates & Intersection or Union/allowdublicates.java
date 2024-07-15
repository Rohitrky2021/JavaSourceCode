public class allowdublicates {
    class Solution {
        // public int[] intersect(int[] nums1, int[] nums2) {
             public int[] intersect(int[] nums1, int[] nums2) {
             HashMap<Integer, Integer> freqMap1 = new HashMap<>();
            HashMap<Integer, Integer> freqMap2 = new HashMap<>();
    
            // Populate freqMap1 with the frequency of elements in nums1
            for (int num : nums1) {
                freqMap1.put(num, freqMap1.getOrDefault(num, 0) + 1);
            }
    
            // Populate freqMap2 with the frequency of elements in nums2
            for (int num : nums2) {
                freqMap2.put(num, freqMap2.getOrDefault(num, 0) + 1);
            }
    
            // Find the common elements that exist in both freqMap1 and freqMap2
            List<Integer> commonElements = new ArrayList<>();
            for (int num : freqMap1.keySet()) {
                if (freqMap2.containsKey(num)) {
                    int minFrequency = Math.min(freqMap1.get(num), freqMap2.get(num));
                    for (int i = 0; i < minFrequency; i++) {
                        commonElements.add(num);
                    }
                }
            }
    
            // Convert the list of common elements to an array
            int[] output = new int[commonElements.size()];
            for (int i = 0; i < commonElements.size(); i++) {
                output[i] = commonElements.get(i);
            }
    
            return output;
        }
        // }
        // M2_____________________-------------------->

        public int[] intersect(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i : nums1){
                int freq = map.getOrDefault(i, 0);
                map.put(i, freq + 1);
            }
            ArrayList<Integer> list = new ArrayList<>();
            for(int i : nums2){
                if(map.get(i) != null && map.get(i) > 0){
                    list.add(i);
                    map.put(i, map.get(i) - 1);
                }
            }
            int[] ret = new int[list.size()]; 
            for(int i = 0; i < list.size();i++){
                ret[i] = list.get(i);
            }
            return ret;
        }
    }
}
