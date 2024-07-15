//WAP to check if a number is prime or not
public class checkifnumberprimeornot {
    public static boolean isPrime(int n) {
        //corner cases
        //corner case for number 1
        if(n==2)
        {
            return true;
        }
        //if the above statement turns true then the below code will not be executed
        for(int i=2; i<=n-1; i++)
        {
            if(n%i==0) { //completly dividing
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPrime(5));
    }
}