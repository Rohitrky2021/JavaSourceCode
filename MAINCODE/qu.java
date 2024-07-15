
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class qu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Length of the array
            int[] arr = new int[n]; // Array elements

            LinkedHashSet hm=new LinkedHashSet<>();
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                hm.add(arr[i]);
            }
            // for (int i = 0; i < hm.size(); i++) {
            //     arr[i]=hm.toArray()
            // }
        //    return hm.toArray();
        //    hm.toArray();


            System.out.println(hm);

            // String op=String.valueOf(n);
            // int m=op.length();
            // char check[]=op.toCharArray();
            
            // Arrays.sort(check, Comparator.reverseOrder());
            // // Collections.sort(check, Collections.reverseOrder());
            // op=check.toString();
            // // String po=op.
            // for (int i = 0; i <m ; i+=2) {
            //     if(op.charAt(i)=='(' && op.charAt(i+1)!=')' || op.charAt(i)=='[' && op.charAt(i+1)!=']' ||op.charAt(i)=='{' && op.charAt(i+1)!='}'  ){
            //         return false;
            //     }
            // }
            // return true;


            int count = getOperationsCount(arr); // Count of operations

            System.out.println(count);
        }
    }

    private static int getOperationsCount(int[] arr) {
        int ones = 0; // Count of 1s in the array
        int minusOnes = 0; // Count of -1s in the array

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                ones++;
            } else if (arr[i] == -1) {
                minusOnes++;
            }
        }
        if(minusOnes-2==ones && minusOnes%2!=0){
            return 1;
        }else if(minusOnes-2==ones && minusOnes%2==0){
            return 2;
        }

        // The minimum number of operations required is the minimum count between 1s and -1s
        return Math.abs(ones-minusOnes);
    }
}
