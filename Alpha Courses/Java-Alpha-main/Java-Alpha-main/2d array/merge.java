
import java.util.*;

public class merge {
    public static void mergee(int[] num1,int[] num2, int x, int y) {
     

        for(int i = x;i< x+y ;i++){
            num1[i]=num2[i-x];
        }
        Arrays.sort(num1);
        
    }
    public static void main(String[] args) {
        int num1[] = {1,3,5,0,0,0};
        int num2[] = {2,4,6};
        int num1x = 3;
        int num2x = 3;

        mergee(num1,num2,num1x,num2x);

        for(int i=0; i<num1.length;i++){
            System.out.print(num1[i]);
        }
    }
}
