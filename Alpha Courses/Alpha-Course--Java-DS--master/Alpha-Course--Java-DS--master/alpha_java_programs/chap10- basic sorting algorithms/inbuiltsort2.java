//WAP on inbuilt sort algorithm using collections package
import java.util.Arrays;
import java.util.Collections;
public class inbuiltsort2 {
    public static void printarray(Integer arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static int compare(int a, int b) {
        //a < b -ve
        //a == b 0
        //a > b +ve
        return a-b;
    }
    public static void main(String[] args) {
        Integer arr[] = {5,4,1,3,2};
        Arrays.sort(arr,Collections.reverseOrder());
        printarray(arr);
    }
}
