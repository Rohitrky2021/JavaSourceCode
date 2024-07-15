import java.util.*;
import java.util.Scanner;
public class array_as_arg {
    public static void main(String[] args){
        int marks[]={1,2,3,4,5,6};
        System.out.println(marks[0]);
        // System.out.println("yes it at :"+ bin_search(marks, 25));
        System.out.println(bin_search(marks, 7));

        reverse(marks);
        System.out.println("ur  values are");
        for(int i=0;i<6;i++)
        System.out.print(marks[i]+" ");

    }
public static int bin_search(int marks[],int key){
    int l=0,e=(marks.length-1),c;
    
    while(l<=e){//by using the stair case method
        
        // for(int i=0;i<=marks.length;i++){
            c=(l+e)/2;
            if(marks[c]==key){
                System.out.println("ya this is the key");
                return c;
            }
            else if(marks[c]>key){
                e=c-1;
            System.out.println("right one shifted");
           }
        else if(marks[c]<key){
            l=c+1;
            System.out.println("left one shifted");
        }
        else{
          System.out.println("sorry key is not available" );  
        }
        
    }
    return -1;
}

public static void reverse(int marks[]){
    int l=0,e=marks.length-1,m=0,n=0;
    while(l<=e){
        // swap(marks[l],marks[e]);
        m=marks[l];
        marks[l]=marks[e];
        marks[e]=m;
        l++;
        e--;
        
    }
    
System.out.println("the array after swap : " + marks[0]+marks[1]);

}
}

