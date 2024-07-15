import java.util.ArrayList;
import java.util.List;

class A {
    public int minOperations(List<Integer> nums, int k) {
        List<Integer> targetValues = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            targetValues.add(i);
        }
        
        int n = nums.size();
        int i = n - 1;

        while (!targetValues.isEmpty() && i >= 0) {
            if (nums.get(i) == targetValues.get(targetValues.size() - 1)) {
                targetValues.remove(targetValues.size() - 1);
            }
            i -= 1;
        }

        return n - i - 1;
    }
}
