import java.util.*;
public class chefScore {
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int arr[]=new int[2];
        while(T-->0){
           for (int i = 0; i < arr.length; i++) {
               arr[i]=sc.nextInt();
            }
            if(arr[0]<arr[1]){
                System.out.println(arr[0]);
            }
            else{
                int c=(arr[0]/arr[1])+(arr[0]%arr[1]);
                System.out.println(c);
            }
            
            

           }

        }
        
    }

