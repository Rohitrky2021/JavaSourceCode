 
import java.util.List;

public class Max_Balance_shipment {
    public static int maxBalancedShipments(List<Integer> a) {
        int n = a.size();
        int ans = 0;
        int prev = -1;
        boolean f = false;

        for (int i = n - 1; i >= 0; i--) {
            if (prev == -1) {
                prev = a.get(i);
                continue;
            }
            if (a.get(i) > prev) {
                f = true;
                ans++;
                prev = -1;
            } else if (f) {
                prev = a.get(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // Test the method with sample input
        List<Integer> a = List.of(1,2,3,2);
        System.out.println(maxBalancedShipments(a)); // Output will depend on the input list
    }
}



// int maxBalancedShipments(vector<int>&a) {
//     
//         int n=a.size();
//         int ans=0;
//         int prev=-1;
//         bool f=0;
//         for(int i=n-1;i>=0;i--)
//         {
//             if(prev==-1) { prev=a[i]; continue;}
//             if(a[i]>prev) { f=1; ans++; prev=-1;}
//             else if(f) prev=a[i];
//         }
//         return ans;
//     }
    
//     Amazon ✅



    