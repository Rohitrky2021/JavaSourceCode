public class digitsumSQuare {
   
        public boolean isHappy(int n) {
            int slow = n;
            int fast = n;
            
            do {
                slow = getSumOfSquares(slow);
                fast = getSumOfSquares(getSumOfSquares(fast));
            } while (slow != fast);
            
            return slow == 1;
        }
        
        private int getSumOfSquares(int num) {
            int sum = 0;
            while (num != 0) {
                int digit = num % 10;
                sum += digit * digit;
                num /= 10;
            }
            return sum;
        }
    }
    //usiung fast ans slow pointer 
    

