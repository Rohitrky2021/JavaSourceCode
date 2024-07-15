public class Contest_Solutions {

    //  A - 100299. Check if Grid Satisfies Conditions

    class Solution {
        public boolean satisfiesConditions(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
    
            // Check if all cells in a row are equal
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (grid[i][j] == grid[i][j + 1])
                        return false;
                }
            }
            
            // Check if all cells in a column are different
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < m - 1; i++) {
                    if (grid[i][j] != grid[i + 1][j])
                        return false;
                }
            }
            
            return true; // All conditions satisfied
        }
    }
// ---------------------------------------------->------------->>>>>>

    // B - 100302. Maximum Points Inside the Square

    class Solution {
        public int maxPointsInsideSquare(int[][] points, String s) {
            int n = points.length;
            for (int i = 0; i < n; i++) {
                points[i][0] = Math.abs(points[i][0]);
                points[i][1] = Math.abs(points[i][1]);
            }
            int l = 0;
            int r = (int) 1e9;
            int ans = 0;
            while (l <= r) {
                int mid = (l + r) / 2;
                Map<Character, Integer> m = new HashMap<>();
                int f = 1;
                for (int i = 0; i < n; i++) {
                    if (points[i][0] <= mid && points[i][1] <= mid) {
                        m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
                    }
                }
                for (Map.Entry<Character, Integer> entry : m.entrySet()) {
                    if (entry.getValue() > 1) {
                        f = 0;
                        break;
                    }
                }
                if (f == 1) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (points[i][0] <= ans && points[i][1] <= ans) {
                    cnt++;
                }
            }
            return cnt;
        } }
// ---------------------------------------------->------------->>>>>>

//  C - 100289. Minimum Substring Partition of Equal Character Frequency

    class Solution {

        int[] dp;

        public int F(int i, String s) {
            if (i < 0) return 0;

            if (dp[i] != -1) return dp[i];

            int[] freq = new int[26];
            int ans = 5005;

            for (int j = i; j >= 0; j--) {
                freq[s.charAt(j) - 'a'] += 1;
                int mini = 5005, maxi = 0;

                for (int k = 0; k < 26; k++) {
                    if (freq[k] != 0) {
                        mini = Math.min(mini, freq[k]);
                        maxi = Math.max(maxi, freq[k]);
                    }
                }

                if (mini == maxi) {
                    ans = Math.min(ans, 1 + F(j - 1, s));
                }
            }

            return dp[i] = ans;
        }

        public int minimumSubstringsInPartition(String s) {
            dp = new int[1002];
            Arrays.fill(dp, -1);
            return F(s.length() - 1, s);
        }
 
    }
}
   