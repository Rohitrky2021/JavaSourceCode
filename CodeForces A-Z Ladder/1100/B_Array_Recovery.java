import java.util.Scanner;

public class B_Array_Recovery {  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int test = 0; test < t; test++) {
            int n = scanner.nextInt();
            int[] ans = new int[n + 1];
            
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                if (x != 0 && ans[i] - x >= 0) {
                    System.out.println(-1);
                    break;
                } else {
                    ans[i + 1] = ans[i] + x;
                }
            }
            
            if (ans[n] != 0) {
                System.out.println(-1);
            } else {
                for (int i = 1; i <= n; i++) {
                    System.out.print(ans[i] + " ");
                }
                System.out.println();
            }
        }

        scanner.close();
    }
}




// import java.util.Scanner;
// // https://codeforces.com/problemset/problem/1739/B
 
// public class B_Array_Recovery {  
//     public static void main(String[] args) {

//         Scanner scanner = new Scanner(System.in);
//         int t = scanner.nextInt();

//         while (t-- > 0) {
//             int n = scanner.nextInt();
//             int[] d = new int[n];

//             for (int i = 0; i < n; i++) {
//                 d[i] = scanner.nextInt();
//             }

//             int[] a = new int[n];
//             a[0] = d[0];
            
//             a[1] = d[0];
            

//             boolean multipleSolutions = false;

//             for (int i = 2; i < n; i++) {
//                 int prevValue = a[i - 1];
//                 if (!(d[i] == 0 || (prevValue - d[i] < 0))) {
//                     multipleSolutions = true;
//                     break;
//                 }
//                 a[i] = prevValue + d[i];
//             }

//             if (multipleSolutions) {
//                 System.out.println("-1");
//             } else {
//                 for (int i = 0; i < n; i++) {
//                     System.out.print(a[i] + " ");
//                 }
//                 System.out.println();
//             }
//         }

    //     scanner.close();
    // Scanner scanner = new Scanner(System.in);
    // int t = scanner.nextInt();
    
    // while (t-- > 0) {
    //     int n = scanner.nextInt();
    //     int[] d = new int[n];
        
    //     for (int i = 0; i < n; i++) {
    //         d[i] = scanner.nextInt();
    //     }
        
    //     int[] a = new int[n];
    //     a[0] = d[0];
    //     a[1] = d[1]+d[0];
    // // int a=0;
        
    //     boolean multipleSolutions = false;
        
    //     for (int i = 2; i < n; i++) {
    //         if (!(d[i] == 0 || (a[i-1]-d[i]<0))) {
    //             multipleSolutions = true;
    //             break;
    //         }
    //         a[i]= a[i-1] + d[i];
    //     }
        
    //     if (multipleSolutions) {
    //         System.out.println("-1");
    //     } else {
    //         for (int i = 0; i < n; i++) {
    //             System.out.print(a[i] + " ");
    //         }
    //         System.out.println();
    //     }
    // }
    
    // scanner.close();



    // Scanner key = new Scanner(System.in);
    // int t = key.nextInt();
    
    // for (int i = 0; i < t; i++) {
    //     int f = 0;
    //     int n = key.nextInt();
    //     int[] d = new int[n + 1];
        
    //     for (int j = 1; j <= n; j++) {
    //         d[j] = key.nextInt();
    //     }
        
    //     int a = d[1];
        
    //     for (int g = 2; g <= n; g++) {
    //         if (a - d[g] < 0 || d[g] == 0) {
    //             a = a + d[g];
    //         } else {
    //             System.out.println(-1);
    //             f = 1;
    //             break;
    //         }
    //     }
        
    //     if (f != 1) {
    //         int temp = d[0];
    //         for (int j = 1; j <= n; j++) {
    //             System.out.print((d[j] + temp) + " ");
    //             temp = temp + d[j];
    //         }
    //         System.out.println();
    //     }
    // }
// }
// }
 
// public class Main {
//     public static Scanner obj = new Scanner(System.in);
//     public static PrintWriter out = new PrintWriter(System.out);

//     public static void main(String[] args) {
//         int len = obj.nextInt();
//         while (len-- != 0) {
//             int n = obj.nextInt();
//             int[] a = new int[n];
//             int[] ans = new int[n];
//             for (int i = 0; i < n; i++) a[i] = obj.nextInt();
//             ans[0] = a[0];
//             boolean tell = true;
//             for (int i = 1; i < n; i++) {
//                 int val = ans[i - 1];
//                 int v1 = val + a[i];
//                 int v2 = val - a[i];
//                 if (v2 >= 0 && v1 != v2) tell = false;
//                 ans[i] = val + a[i];
//             }
//             if (!tell) out.println(-1);
//             else {
//                 for (int i = 0; i < n; i++) out.print(ans[i] + " ");
//                 out.println();
//             }
//         }
//         out.flush();
//     }
// }

 
 
public class abhi {
	
 
	public static void main(String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n=sc.nextInt();
			boolean b=true;
			
			int [] da=new int[n];
			int [] aa=new int[n];
			
			for(int j=0;j<n;j++){
				da[j]=sc.nextInt();
			}
			
			aa[0]=da[0];
			
			for(int k=1;k<n;k++){
				if(((aa[k-1]-da[k])>=0) && (da[k]!=0) &&(aa[k-1]!=0)){
					b=false;
				}
				
				else{
					aa[k]=aa[k-1]+da[k];
				}
			}
			
			if(b==true){
				for(int j=0;j<n;j++){
					System.out.print(aa[j] +" " );
				}
				
				System.out.println();
			}
			else{
				System.out.println("-1");
			}
		
 
			
			
		
			
		}
 
	}
}