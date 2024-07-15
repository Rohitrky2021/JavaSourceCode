  import java.util.Scanner;
//   https://codeforces.com/problemset/problem/69/A
    public class A_Young_Physits {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
    
            // Read the number of force vectors
            int n = sc.nextInt();
            
            int sumX = 0, sumY = 0, sumZ = 0;
    
            // Read and calculate the sum of force vectors
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();// three integers each: the xi coordinate, the yi
                int y = sc.nextInt();
                int z = sc.nextInt();//   coordinate, the zi
    
                sumX += x;
                sumY += y;
                sumZ += z;
            }
    
            // Check if the sum is (0, 0, 0)
            if (sumX == 0 && sumY == 0 && sumZ == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
    
            // Close the scanner
            sc.close();
        }
    }
    