import java.util.*;

public class B_16 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0){
            int N=sc.nextInt();
            int arr[]=new int[N];
            int ans[]=new int [N];
            for (int i = 0; i <N; i++) {
                arr[i]=sc.nextInt();
                ans[i]=arr[i];
            }
            int count=0,j=0;
            Arrays.sort(ans);
            for ( j= 0; j< ans.length; j++) {
                if(arr[j]!=ans[j])
                    count++;
                
                }
                System.out.println(count/2);
        }
    }
}
