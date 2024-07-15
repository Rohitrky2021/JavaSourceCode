public class ok {
    public static int calculateLevelSum(int[] arr, int k) {
        int sum = 0;
        int startIndex = (int) Math.pow(2, k - 1) - 1;  
        int endIndex = Math.min((int) Math.pow(2, k) - 1, arr.length);  
        
        for (int i = startIndex; i < endIndex; i++) {
            sum += arr[i];
        }
        
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7,8};
        int k = 3; // Level  
        int sum = calculateLevelSum(arr, k);
        System.out.println("Sum of nodes at level " + k + ": " + sum);
    }
}
