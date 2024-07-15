public class h3subaaray {
    // public class MaxMidSum {

        // https://leetcode.com/discuss/interview-question/3263965/Trilogy-Innovations
        
        public static int maxMidSum(int[] A) {
            int n = A.length;
            int m_cur = 0;
            int m_sum = Integer.MIN_VALUE;
    
            int temp = 1; // getting the start index and the end index for the mid subarray
            int start = 1;
            int end = 1;
            int j = 1;
    
            while (j < n - 1) {
                m_cur += A[j];
                if (m_cur > m_sum) {
                    m_sum = m_cur;
                    end = j;
                }
    
                if (A[temp] < 0) {
                    start = end;
                }
    
                if (m_cur < 0) {
                    m_cur = 0;
                    temp = j;
                }
    
                j++;
            }
    
            int p_sum = A[0];
            int i = 1;
    
            while (i < start) {
                if (A[i] > 0) {
                    p_sum += A[i];
                }
                i++;
            }
    
            int l_sum = A[n - 1];
            int k = n - 2;
    
            while (k > end) {
                if (A[k] > 0) {
                    l_sum += A[k];
                }
                k--;
            }
    
            System.out.println("p_sum=" + p_sum + " m_sum=" + m_sum + " l_sum=" + l_sum + " start=" + start + " end=" + end);
            return p_sum + m_sum + l_sum;
        }
    
        public static void main(String[] args) {
            int[] A = {1, -2, 3, -1, 2, 5, -3, 4};
            int result = maxMidSum(A);
            System.out.println("Result: " + result);
        }
    }
    
// }
