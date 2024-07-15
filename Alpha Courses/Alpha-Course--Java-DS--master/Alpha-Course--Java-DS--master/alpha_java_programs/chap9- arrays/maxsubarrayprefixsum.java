//WAP to print maximum subarray- prefix sum
public class maxsubarrayprefixsum {
    public static void prefixsum(int numbers[]) {
        int currSum = 0;
        int maxSum = Integer.MAX_VALUE;
        int prefix[] = new int[numbers.length];
        prefix[0] = numbers[0];
        //calculate prefix array
        for(int i=1;i<prefix.length;i++) {
            prefix[i] = prefix[i-1] + numbers[i]; //formula to calculate the prefix
        }
        for(int i=0; i<numbers.length; i++) {
            int start = i;
            for(int j=i;j<numbers.length;j++) {
                int end = j;
                currSum = start ==0 ? prefix[end]: prefix[end]-prefix[start-1]; //formula to calculae using prefix sum with ternary operator
                if(maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("maximum sum is: " +maxSum);
    }
    public static void main(String[] args) {
        int numbers[] = {2,4,6,8,10};
        prefixsum(numbers);
    }   
}
