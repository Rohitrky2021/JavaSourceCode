import java.util.Scanner;

public class oct1 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0){
            int n=sc.nextInt();
            int l1[]=new  int[n];
            
            for( int i=0;i<n;i++){
                l1[i]=sc.nextInt();
                // System.out.println(marks[i]);
            }
            for( int i=0;i<n;i++){
                // l1[i]=sc.nextLong();
                System.out.print(l1[i]+" ");
            }
            T=T-1;
            int m=sc.nextInt();
            int l2[]=new  int[m];
            for( int i=0;i<m;i++){
                l2[i]=sc.nextInt();
                // System.out.println(marks[i]);
            }
            for( int i=0;i<m;i++){
                // l1[i]=sc.nextLong();
                System.out.print(l2[i]+" ");
            }



            
            T=T-1;


            
            
        }

    }
}
