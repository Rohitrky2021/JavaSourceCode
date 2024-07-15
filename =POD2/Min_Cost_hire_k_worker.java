/**
 * Min_Cost_hire_k_worker
 */
public class Min_Cost_hire_k_worker {

  /**
     * Approach 1: Brute Force  
     * ? Complexity
     ** Time complexity:O(2^n) 
     ** Space complexity: O(n) 
     */
    
    class Solution {
        public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
            int n = quality.length;
            int[][] w = new int[n][2];
            for(int i = 0; i<n; i++){
                w[i][0] = quality[i];
                w[i][1] = wage[i];
            }
            double ans = Double.MAX_VALUE; // infinity
            // iterate through all subsets
            for(int i = 0; i<1<<n; i++){
                // check if subset size is k
                if(Integer.bitCount(i) == k){
                    double ratio = 0;
                    for(int j = 0; j<n; j++){ // find maximum wage to quality ratio
                        if(((i>>j)&1) != 0){
                            // if j is in the subset
                            ratio = Math.max(ratio,w[j][1]/(double)w[j][0]);
                        }
                    }
                    double cost = 0;
                    for(int j = 0; j<n; j++){
                        if(((i>>j)&1) != 0){
                            // if j is in the subset
                            cost+=ratio*w[j][0];
                        }
                    }
                    ans = Math.min(ans,cost);
                }
            }
            return ans;
        }
    }
  /**
     * Approach 2: Sorting and Priority Queue
     * ? Complexity
     ** Time complexity: O(nlogn + nlogk)
     ** Space complexity: O(n + k)
     */

    class Solution {
        public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
            
            int n = quality.length;
            
            List<Pair<Double, Integer>> wageToQualityRatioList = new ArrayList<>();
            
            for (int i = 0 ; i < n ; i++) {
                wageToQualityRatioList.add(new Pair((double) wage[i] / quality[i], quality[i]));
            }
            
            Collections.sort(wageToQualityRatioList, (x, y) -> Double.compare(x.getKey(), y.getKey()));
            
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> (y - x));
            
            
            int curTotalQuality = 0;
            int curQuality = 0;
            
            for (int i = 0 ; i < k ; i++) {
                curQuality = wageToQualityRatioList.get(i).getValue();
                maxHeap.add(curQuality);
                curTotalQuality += curQuality;
            }
            
            double curRatio = wageToQualityRatioList.get(k-1).getKey();
            double ans = curTotalQuality * curRatio;
            
            for (int i = k ; i < n ; i++) {
                curRatio = wageToQualityRatioList.get(i).getKey();
                curQuality = wageToQualityRatioList.get(i).getValue();
                
                maxHeap.add(curQuality);
                curTotalQuality += curQuality - maxHeap.poll();
                ans = Math.min(ans, curTotalQuality * curRatio);
            }
            
            return ans;
        }
    }
}