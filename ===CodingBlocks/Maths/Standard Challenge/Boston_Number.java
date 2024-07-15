
import java.util.Scanner;

public class Boston_Number {//The Number whoes Sum of Digits is equal to the  sum of the prime factor digits 
    // Take Prime Factorisation not By Sieve Tube but By Square Root method ---> Then sum digits by normal while loop
    // EX:-  22==> 11*2 
        // 2+2=4 and 1+1+2=4 


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int sum = 0;
        int sum_n = 0;
        int temp = n;

        while (temp > 0) {
            sum_n = sum_n + (temp % 10);
            temp /= 10;
        }

        while (n % 2 == 0) {
            sum += 2;
            n = n / 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
            while (n % i == 0) {
                int temp1 = i;
                while (temp1 > 0) {
                    sum = sum + (temp1 % 10);
                    temp1 /= 10;
                }
                n = n / i;
            }
        }

        if (n > 2) {
            while (n > 0) {
                sum = sum + (n % 10);
                n /= 10;
            }
        }

        if (sum_n == sum)
            System.out.print("1");
        else
            System.out.print("0");
    }
}
