public class NonAdjancentPermutn {
    class Solution {
        public String reorganizeString(String s) {
            String ans="";
    
            boolean[] visited = new boolean[500];
            char nums[]=s.toCharArray();
            
    
            for(int i=0;i<s.length();i++){
            reorganiseString(ans+s.charAt(i));
            reorganiseString(ans);
    
            }
            

            if (current.size() == nums.length) {
                result.add(new ArrayList<>(current));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[nums[i]]) {
                    continue;
                }
                 if (visited[i]) {
                    continue;
                    // ---------------->when revise ones uncomment and run this !
                }
                visited[i] = true;
                current.add(nums[i]);
                backtrack(nums, visited, current, result);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
    
            
        }
    }

    public static void main(String[] args) {

    }
    
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            List<String> current = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            backtrack(nums, visited, current, result);
            return result;
        }
    
        private void backtrack(int[] nums, boolean[] visited, string current, List<List<Integer>> result) {
            if (current.size() == nums.length) {
                
                result.add(new ArrayList<>(current));
                return current;
            }
    
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                //  if (visited[i]) {
                //     continue;
                //     // ---------------->when revise ones uncomment and run this !
                // }
                visited[i] = true;
                curr+=nums[i];
                // current.add(nums[i]);
                backtrack(nums, visited, current, result);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }
    
    


}