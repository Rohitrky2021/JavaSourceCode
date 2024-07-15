import java.util.ArrayList;
import java.util.*;
import java.util.Collections;

public class subarrprintAll {
    public static void main(String args[]){
        int marks[]={1,2,3,4,5,6};
        System.out.println("ur  values are");
        for(int i=0;i<6;i++)
        System.out.print(marks[i]+" ");
        System.out.println();
        pairs(marks);
        // boolean ans=false;
        // // Collections.list(e)
        // ArrayList arr=new ArrayList<>();
        // arr.addAll(marks);
        // while(ans){
        //     // marks[]
        //     Arrays.bi
            
        // }
        // arr.add(target);
        // Collections.sort(arr);
        // Collections.binarySearch(arr, target);
        // marks[marks.length]=target;
        // Arrays.sort(marks);
        // Arrays.binarySearch(marks, target);
        
    }
    public static void pairs(int marks[]){
        int count=0,maxlen=0;
        int csum=0,c=0;
        int maxsum=Integer.MIN_VALUE;
        for(int i=0;i<marks.length;i++){
            int current=marks[i];
            csum=0;
            for(int j=i;j<marks.length;j++){
                // for(int k=i;k<=j;k++){
                    // System.out.print(marks[j]+" ");
                    // if(csum<sum){
                    //     c

                    // }
                    csum += marks[j];

                // }

                if(maxsum<csum){
                    maxsum=csum;
                }
                count++;
                System.out.print(csum);
                System.out.print(" ") ;
                
            }
            System.out.println( );
            
        }
        // System.out.println(count);
        System.out.println(maxsum) ;

    }
}
