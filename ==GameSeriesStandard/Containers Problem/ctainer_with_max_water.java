 
public enum ctainer_with_max_water {
class Solution {

// ==========> Best Explain By Hi-Malik In Soln <===========

    public int maxArea(int[] h) {
        int l=0,r=h.length-1,area=0;

        while(l<r){

         area=Math.max(area,Math.min(h[l],h[r])*Math.abs(l-r));

        if(h[l]>h[r]){
            r--;
        }else{
            l++;
        }


        }
        return area;

    }
}
	public static void main(String[] args) {
		Container_With_Most_Water out = new Container_With_Most_Water();
		Solution2 s = out.new Solution2();

		System.out.println(s.maxArea(new int[]{2,0,2}));
	}

    // time: O(N)
    // space: O(1)
	public class Solution {
	    public int maxArea(int[] height) {
	        int[] h = height;

	        if(h == null || h.length == 0) {
	            return 0;
	        }

	        int l = 0; // left
	        int r = h.length - 1; // right

	        int max = (r - l) * Math.min(h[l], h[r]); // possibly very first position is max area
	        while(l < r) {
	            if(h[l] < h[r]) {
	                l++;
	            } else {
	                r--;
	            }

	            max = Math.max(max, (r - l) * Math.min(h[l], h[r]));
	        }

	        return max;
	    }
	}

	// N^2. Time Limit Exceeded
	public class Solution2 {
		public int maxArea(int[] h) { // h: height
			if (h == null || h.length == 0) {
				return 0;
			}

			// possibly sanity check for negative int in array, throw something for debugging
			// never trust the passed in parameter!

			int i = 0;
			int max = Integer.MIN_VALUE;
			while (i < h.length) {

				int j = i + 1;
				while (j < h.length) {

					max = Math.max(max, (j - i) * Math.min(h[i], h[j]));
					j++;
				}

				i++;
			}

			return max;
		}
	}

}

############

class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int res = 0;
        while (i < j) {
            int t = (j - i) * Math.min(height[i], height[j]);
            res = Math.max(res, t);
            if (height[i] < height[j])
                ++i;
            else
                --j;
        }
        return res;
    }
}
