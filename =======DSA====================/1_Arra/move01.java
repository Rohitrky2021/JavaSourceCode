public class move01 {
    public static class Solution {
        public long maximumSteps(String s) {
            char a[] = s.toCharArray();
            long sum = calculateSum(a);
            System.out.println(sum);
            return sum;
        }

        private long calculateSum(char a[]) {
            int onesToRight = 0;
            long sum = 0;

            for (int i = a.length - 1; i >= 0; i--) {
                if (a[i] == '0') {
                    sum += onesToRight+1;
                } else {
                    onesToRight++;
                }
            }

            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maximumSteps("110100");
    }
}


class Solution {
    public long minimumSteps(String s) {
        long cnt = 0, ans = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '1') {
                ans += cnt;
            } else {
                cnt++;
            }
        }
        return ans;
    }
}