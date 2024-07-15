
    import java.util.Arrays;

    public class mindiff {
        public static int minimizeSumOfAbsoluteDifferences(int[] arr1, int[] arr2) {
           
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            
            int sum = 0;
            
            for (int i = 0; i < arr1.length; i++) {
                sum += Math.abs(arr1[i] - arr2[i]);
            }
            
            return sum;
        }
        
        public static void main(String[] args) {
            int[] arr1 = {1,2,2};
            int[] arr2 = {5,2,4};
            
            int result = minimizeSumOfAbsoluteDifferences(arr1, arr2);
            System.out.println("Minimum sum of absolute differences: " + result);
        }
    }
    