public class math{
 
        public static long calculateSum(long i, long j, long k) {
            
            long sumIJ = (j * (j + 1) / 2) - ((i - 1) * i / 2);
    
            
            long sumJK = (j - 1) * j / 2 - (k - 1) * k / 2;
    
         
            return sumIJ + sumJK;
        }

        public static void main(String[] args) {
            long i = 5;
            long j = 9;
            long k = 6;
            long result = calculateSum(i, j, k);
            System.out.println(result);
        }
    }
    