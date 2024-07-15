import java.util.Arrays;
import java.util.Scanner;

public class subchange {
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        
        while(T-->0){
           int  n=sc.nextInt();
            int arr[]=new int[n];
           for (int i = 0; i < arr.length; i++) {
            
                arr[i]=sc.nextInt();
            
           }
           for (int i = 0; i < arr.length; i++) {
            
          System.out.println(Arrays.binarySearch(arr, i, n, 3));
          int indx=Arrays.binarySearch(arr, i, n, arr[i]);
           System.out.println(-indx);
           if(i<-indx){
           Arrays.fill(arr, i, -(indx+1), arr[i]);
           }
           for ( i = 0; i < arr.length; i++) {
            
            System.out.println(arr[i]);
            
        
        }
        
        
    }
    if(helpdiffernt(arr)<=2){
     System.out.println("YES");
    //  break;
    }
       
    else{
    
     System.out.println("NO");
    // break;
    }
}
        
    }
    public static int helpdiffernt(int arr[]){
        int copyarr[]=Arrays.copyOf(arr, arr.length);
        int count =0;
        for (int  i = 0; i < arr.length; i++) {
            
            System.out.print(copyarr[i]+ " ");
            
        
        }
        for ( int i = 0; i < arr.length; i++) {
            
            System.out.print(copyarr[i] +" ");
            
        
        }
        Arrays.sort(copyarr);
        for (int i = 0; i < arr.length-1; i++) {
            if(copyarr[i]==copyarr[i+1]){
                count++;
            }
        }
       
        return arr.length-count;
    }
}
// even number
