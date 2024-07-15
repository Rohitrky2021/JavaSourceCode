import java.util.*;

public class ok {
    public static void main(String[] args) {
        int a[]={0,1,1,1,0};
        int c= change(a);
        System.out.println(c);
    }

    public static int change(int a[]) {
        int s=0, e=a.length-1;
        int i=0, count=0;
        int one=0;
        for (int j = e; j >=0; j--) {
            if(a[j]==1)one+=(e-j+1);
        }

        for (int j = 0; j < a.length; j++) {
            if(a[j]==1)count++;
        }
        if(a[e]==1)one+=2;
 

        return one-count;
    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
