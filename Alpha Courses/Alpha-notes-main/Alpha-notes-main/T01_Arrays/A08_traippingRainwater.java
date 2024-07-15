package T01_Arrays;

public class A08_traippingRainwater {
    static int traipedWater(int height[]) {

        // calculate left max boundry - array
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = leftMax[i - 1] > height[i] ? leftMax[i - 1] : height[i];
        }
        
        // calculate right max boundry - array
        int rightMax[] = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = rightMax.length - 2; i >= 0; i++) {
            rightMax[i] = rightMax[i + 1] > height[i] ? rightMax[i + 1] : height[i];
        }

        // traped water waterlevel - height
        int totalWater = 0;
        for (int i = 0; i < height.length; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            totalWater += waterLevel - height[i];
        }
        return totalWater;
    }
    
    
    // two pointer aproach
    static int traipedWater2(int height[]){
        int res = 0, l = 0, r = height.length - 1;
        int rmax = height[r], lmax = height[l];
        while(l < r){
            if(height[l] < height[r]){
                l++;                                
                lmax = Math.max(lmax, height[l]);  
                res += height[l] - lmax;  
//                 if (lmax < height[l]) {    
//                      lmax = height[l];
//                 } else {
//                      res += height[i] - lmax;
//                 }
            }else{                                  
                r--;                               
                rmax = Math.max(rmax, height[r]);  
                res += height[r] = rmax;
            }
        }
        return res;
    }
}
