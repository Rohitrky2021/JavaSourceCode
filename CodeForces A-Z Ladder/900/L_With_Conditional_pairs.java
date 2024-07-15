import java.util.*;

public class L_With_Conditional_pairs {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int testc=sc.nextInt(); // Number of test cases
        while(testc-- > 0){
            int n=sc.nextInt(); // Size of the array
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            Arrays.sort(arr); // Sort the array
            long max=arr[n-1]; // Maximum element
            long min=arr[0];   // Minimum element
            long mnm=0, mxm=0;
            for(int i=0;i<n;i++){
                if(arr[i]==min){
                    mnm++;
                }
                if(arr[i]==max){
                    mxm++;
                }
            }   
            if(max==min){
                // Single occurrence of max difference
                System.out.println((long)(mnm*(mnm-1)));
            }
            else{
                // Multiple occurrences of max difference
                System.out.println((long)(2*mxm*mnm));
            }
        }
    } 
}
