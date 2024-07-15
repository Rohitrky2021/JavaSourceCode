import java.util.*;

public class Sort01 {
    public static void main(String[] args) {
        int a[]={0,1,0,1,1};
        
        int c= change(a);
        System.out.println(c);
    }

    public static int change(int a[]) {
        int s=0, e=a.length-1;
        int i=0, count=0;

        while(i<e){
            if(a[i]==1){
                s++;
                i++;
            } else {
                swap(a, e, i);
                count++;
                e--;
            }
        }

        for (int j = 0; j < a.length; j++) {
            System.err.println(a[j]);
        }

        return count;
    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}