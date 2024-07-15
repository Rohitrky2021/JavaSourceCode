// public class  {

    public class trailingzero {
        public static int countTrailingZeroes(int n) {
            int count = 0;
            while (n % 10 == 0) {
                count++;
                n = n / 10;
            }
            return count;
        }
    
        public static void main(String[] args) {
            int number = 1500;
            int trailingZeroes = countTrailingZeroes(number);
            System.out.println("Number of trailing zeroes in " + number + " is " + trailingZeroes);
        }
    }
    
