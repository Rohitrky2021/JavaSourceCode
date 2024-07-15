import java.util.Scanner;

public class A_18 {
    public static Boolean isdupli(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length-1; j++) {
                if(arr[i]==arr[j+1]){
                    return true;
                }
            }
        }
        return false;

    }
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        
        while(T-->0){
            int N=sc.nextInt();
            int K=sc.nextInt();
            int arr[]=new int[N];
          for (int i = 0; i<N; i++) {
            arr[i]=sc.nextInt();
          }
        //   for (int i = 0; i<arr.length; i++) {
        //     System.out.print(arr[i]+" ");
        //   }
          
           if((N/2)>=K){
            System.out.println("No");
           }
           else if(N==K && isdupli(arr)){
            System.out.println("No");
           }
           else{System.out.println("Yes");}
        }
        
    }}

