import java.util.Scanner;
// https://codeforces.com/problemset/problem/1/A
public class A_TheaterSquare {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
    
            // Read input values
            long n = sc.nextLong();//The square area you want to cover has a certain length (given as 'n') 
            long m = sc.nextLong();//and width (given as 'm').
            long a = sc.nextLong();// Sqaure u have of a*a
    
            // Calculate the number of flagstones needed
            long flagstonesNeeded = (long) Math.ceil((double) n / a) * (long) Math.ceil((double) m / a);
    
            // Output the result
            System.out.println(flagstonesNeeded);
    
            // Close the scanner
            sc.close();
        }
    }
    
