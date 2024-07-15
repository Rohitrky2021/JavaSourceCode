public class MaxSumSubse {
    public static int maxSubsequenceSum(int[] sequence) {
        int maxEndingHere = sequence[0];
        int maxSoFar = sequence[0];
        
        for (int i = 1; i < sequence.length; i++) {
            maxEndingHere = Math.max(sequence[i], maxEndingHere + sequence[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
    
    public static void main(String[] args) {
        int[] sequence = {1, -3, 4, -2, -1, 6};
        System.out.println("Maximum sum subsequence: " + maxSubsequenceSum(sequence));
    }
}
