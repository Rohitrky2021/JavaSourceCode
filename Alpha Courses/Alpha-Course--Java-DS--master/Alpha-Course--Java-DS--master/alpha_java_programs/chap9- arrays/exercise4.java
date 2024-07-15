/*
 * Given n non-negative integers representing an elevation map where the 
 * width of each bar is 1, compute how much water it can trap after raining
 */
public class exercise4 {
    public static int trap(int[] height) {
        int n = height.length;
        int res = 0, i=0, r=n-1;
        int rMax = height[r], iMax = height[1];
        while (1<r) {
            if(iMax<rMax) {
                i++;
                iMax = Math.max(iMax, height[i]);
                res += iMax - height[i];
            }
            else {
                r--;
                rMax = Math.max(rMax, height[r]);
                res += rMax - height[r];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int height[] = {4,2,0,6,3,2,5};
        System.out.println(trap(height));
    }
}
