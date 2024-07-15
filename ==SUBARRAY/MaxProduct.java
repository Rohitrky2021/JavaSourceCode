
    import java.util.ArrayList;
    import java.util.List;
    
    public class MaxProduct {
        public List<Integer> productExceptSelf(List<Integer> nums) {
            List<Integer> leftProducts = new ArrayList<>();
            List<Integer> rightProducts = new ArrayList<>();
            List<Integer> result = new ArrayList<>();
    
            int leftProd = 1;
            for (int num : nums) {
                leftProducts.add(leftProd);
                leftProd *= num;
            }
    
            int rightProd = 1;
            for (int i = nums.size() - 1; i >= 0; i--) {
                rightProducts.add(rightProd);
                rightProd *= nums.get(i);
            }
            
            for (int i = nums.size() - 1; i >= 0; i--) {
                result.add(leftProducts.get(i) * rightProducts.get(i));
            }
            
            return result;
        }
    }
    