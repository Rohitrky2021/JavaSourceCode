//WAP to print out the sum of the numbers in the second row of the nums array
public class exercise2 {
    public static void main(String[] args) {
        int nums[][] = {{1,4,9},{11,4,3},{2,2,3}};
        int sum = 0;
        for (int i = 0; i < nums[1].length; i++) {
            sum += nums[1][i];
        }
        System.out.println("The sum of the numbers in the second row is: " + sum);         
    }
}
