//WAP to print all prime numbers in range
public class primenumbersinrange {
    //to check if the number is prime or not
    public static boolean isPrime(int n) {
        if(n==2)
        {
            return true;
        }
        for(int i=2; i<=Math.sqrt(n); i++)
        {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }
    //if the above code returns true then it will go to the below step
    //if false then the range will not be shown
    public static void primesInRange(int n) {
        for(int i=2; i<=n; i++)
        {
            if(isPrime(i)) { //true
                System.out.println(i+" ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        primesInRange(16); //prime numbers from 2 to 16
    }
}
