import java.util.*;
public class tc {
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int arr[]=new int[4];
        while(T-->0){
           for (int i = 0; i < arr.length; i++) {
            // for(int j=0;j<arr.length;j++){
                arr[i]=sc.nextInt();
            // }
           }
           if(arr[0]>=arr[1] && arr[3]>=arr[0]-arr[1]){
            System.out.println("YES");
            
           }
           else if(arr[0]<=arr[1] && arr[2]>=arr[0]-arr[1]){
            System.out.println("YES");
           }
           else{
            System.out.println("NO");
           }

        }
        
    }
}
