import java.util.*;

public class tes {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter a 4-digit number: ");
        // int number1 = scanner.nextInt();
        // int number2 = scanner.nextInt();
        // int number3 = scanner.nextInt();
        // int in = scanner.nextInt();

        // int[] arr = new int[4];
        // int[] arr2 = new int[4];
        // int[] arr3 = new int[4];
        
        // int temp = number1;
        
        // for (int i = 3; i >= 0; i--) {
        //     arr[i] = temp % 10;
        //     temp /= 10;
        // }
        // temp = number2;
        
        // for (int i = 3; i >= 0; i--) {
        //     arr2[i] = temp % 10;
        //     temp /= 10;
        // }
        // temp = number3;
        
        // for (int i = 3; i >= 0; i--) {
        //     arr3[i] = temp % 10;
        //     temp /= 10;
        // }
        // Arrays.sort(arr);
        // Arrays.sort(arr2);
        // Arrays.sort(arr3);
        // int ans=arr[0]*arr[3]*arr[0]-in;
        // System.out.println(ans);
        

        
findRepArray();

        
    }
    public static int findRepArray() {
        int[] input1={1,2,4,1,2,8};
        int input2=6;
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < input2; i++) {
            int num = input1[i];
            
            
            if (num <= 0)
                continue;
            
         
            if (set.contains(num))
                return num; 
            
           
            set.add(num);
        }
        
      System.out.println( input1[0]);
        return input1[0];
    }

}
