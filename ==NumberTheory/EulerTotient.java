import java.util.*;
public class EulerTotient {
    // for let N=12  how many no. r there from 1-->12 who pair with n i.e 12 give GCD 1 i.e co-prime with N=12 
    // you have been given a number n, count the number of integers between 1 to n inclusive, which are co-prime to n.
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(euler(n));
    }


    
    public static int euler(int n) {
        int count = n;
        for (int i = 2; i * i <= n; i++) {

            if (n % i == 0) {
                while (n % i == 0) {
                    n = n / i;
                }
                count = count - count / i;
            }
        }// MAX logN tk jaayega !!

        if (n > 1) {
            count = count - count / n;
        }

        return count;
    }

}

// Constraints
// 1 <= n <= 10^9
// Sample Input
// 7
// Sample Output
// 6


